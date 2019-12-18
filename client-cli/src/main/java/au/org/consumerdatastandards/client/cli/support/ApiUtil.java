/*
 * Consumer Data Standards
 * Sample CLI tool to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated by the codegen artefact
 * https://github.com/ConsumerDataStandardsAustralia/java-artefacts/codegen
 */
package au.org.consumerdatastandards.client.cli.support;

import au.org.consumerdatastandards.client.ApiClient;
import au.org.consumerdatastandards.client.ApiException;
import ch.qos.logback.classic.Logger;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.inject.CreationException;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import okhttp3.Credentials;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.tls.HandshakeCertificates;
import okhttp3.tls.HeldCertificate;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.Base64;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ApiUtil {

    private static final int EXPIRY_BUFFER = 10000;
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(ApiUtil.class);
    private static final List<String> VALID_PROXY_TYPES = Arrays.asList("HTTP:", "HTTPS:", "SOCKS:");

    private static final JsonParser parser = new JsonParser();
    private static final HashMap<String, JsonObject> discoveredConfigs = new HashMap<>();

    public static ApiClient createApiClient(ApiClientOptions clientOptions) throws ApiException {
        String serverUrl = clientOptions.getServerUrl();
        if (StringUtils.isBlank(serverUrl)) {
            LOGGER.error("Server Base URL is currently unset, cannot proceed until it is specified using `server` command");
            throw new ApiException("Server URL not set, please use `server` command to set Server URL first");
        }
        if (!isValidUrl(serverUrl)) {
            LOGGER.error("Invalid server url of {} specified, please double check", serverUrl);
            throw new ApiException("Invalid Server URL, please double check it");
        }
        ApiClient apiClient = new ApiClient();
        String proxy = clientOptions.getProxy();
        if (!StringUtils.isBlank(proxy)) {
            setProxy(apiClient, proxy);
            LOGGER.info("Proxy is set to {}", proxy);
        }
        OkHttpClient originalHttpClient = apiClient.getHttpClient();
        apiClient.setBasePath(serverUrl);
        LOGGER.info("Server Base URL is set to {}", serverUrl);
        String userAgent = clientOptions.getUserAgent();
        if (!StringUtils.isBlank(userAgent)) {
            apiClient.setUserAgent(userAgent);
            LOGGER.info("User Agent is set to {}", userAgent);
        }

        String accessToken = clientOptions.getAccessToken();
        if (StringUtils.isNotBlank(accessToken) || StringUtils.isNotBlank(clientOptions.getRefreshToken())) {
            Integer exp = null;
            Map<String, Object> claims = null;
            if (StringUtils.isNotBlank(accessToken)) {
                try {
                    claims = parseClaims(accessToken);
                    exp = (Integer) claims.get("exp");
                } catch (ApiException e) {
                    LOGGER.info("Invalid access token.");
                }
            }
            if (exp == null || exp.longValue() * 1000 < System.currentTimeMillis() + EXPIRY_BUFFER) {
                accessToken = acquireNewAccessToken(clientOptions.getRefreshToken(), clientOptions.getAuthServer(),
                        clientOptions.getClientId(), clientOptions.getJwksPath(), originalHttpClient);
                clientOptions.setAccessToken(accessToken);
                claims = parseClaims(accessToken);
            }
            apiClient.addDefaultHeader("Authorization", "Bearer " + accessToken);
            apiClient.addDefaultHeader("x-cds-subject", claims.get("sub").toString());
        }
        if (clientOptions.isMtlsEnabled()) {
            validateClientCertSettings(clientOptions);
            String rootCaFilePath = clientOptions.getRootCaFilePath();
            String clientKeyFilePath = clientOptions.getKeyFilePath();
            String clientCertFilePath = clientOptions.getCertFilePath();
            try {
                X509Certificate rootCaCertificate = loadCertificate(rootCaFilePath);
                X509Certificate certificate = loadCertificate(clientCertFilePath);
                PublicKey publicKey = certificate.getPublicKey();
                PrivateKey privateKey = loadPrivateKey(clientKeyFilePath);
                KeyPair keyPair = new KeyPair(publicKey, privateKey);
                HeldCertificate heldCertificate = new HeldCertificate(keyPair, certificate);
                OkHttpClient httpClient = buildHttpClient(originalHttpClient, rootCaCertificate, heldCertificate);
                apiClient.setHttpClient(httpClient);
            } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException | CreationException | CertificateException e) {
                throw new ApiException(e);
            }
            LOGGER.info("Enabled MTLS");
        } else {
            apiClient.setHttpClient(originalHttpClient);
            LOGGER.info("Disabled MTLS");
        }
        apiClient.setDebugging(clientOptions.isDebugEnabled());
        LOGGER.info("Debugging is set to {}", apiClient.isDebugging());
        apiClient.setVerifyingSsl(clientOptions.isVerifyingSsl());
        LOGGER.info("Verifying SSL is set to {}", apiClient.isVerifyingSsl());

        return apiClient;
    }

    private static String acquireNewAccessToken(String refreshToken, String authServer, String clientId,
            String jwksPath, OkHttpClient httpClient) throws ApiException {
        try {
            JsonObject jsonObject = discoveredInfo(httpClient, authServer);
            String tokenEndpoint = jsonObject.get("token_endpoint").getAsString();
            JWKSet jwkSet = JWKSet.load(new File(jwksPath));
            RSAKey rsaKey = (RSAKey) jwkSet.getKeys().get(0);
            JWTClaimsSet claims = new JWTClaimsSet.Builder()
                    .subject(clientId)
                    .issuer(clientId)
                    .audience(tokenEndpoint)
                    .expirationTime(new Date(System.currentTimeMillis() + 5 * 60 * 1000)) // the assertion expires in 5 minutes
                    .jwtID(UUID.randomUUID().toString())
                    .build();
            JWSObject signedJWT = new SignedJWT(new JWSHeader.Builder(JWSAlgorithm.RS256).keyID(rsaKey.getKeyID()).build(), claims);
            RSASSASigner signer = new RSASSASigner(rsaKey);
            signedJWT.sign(signer);
            RequestBody postBody = new FormBody.Builder()
                    .add("grant_type", "refresh_token")
                    .add("client_id", clientId)
                    .add("client_assertion_type", "urn:ietf:params:oauth:client-assertion-type:jwt-bearer")
                    .add("client_assertion", signedJWT.serialize())
                    .add("refresh_token", refreshToken)
                    .add("scope", "openid profile")
                    .build();
            Request req = new Request.Builder().url(tokenEndpoint).post(postBody).build();
            String response = httpClient.newCall(req).execute().body().string();
            JsonObject responseObject = parser.parse(response).getAsJsonObject();
            if (responseObject.has("error")) {
                JsonElement msg = responseObject.get("error_description");
                throw new ApiException((msg == null ? responseObject.get("error") : msg).getAsString());
            }
            return responseObject.get("access_token").getAsString();
        } catch (IOException | ParseException | JOSEException e) {
            throw new ApiException(e);
        }
    }

    private static JsonObject discoveredInfo(OkHttpClient httpClient, String authServer) throws IOException {
        JsonObject config = discoveredConfigs.get(authServer);
        if (config == null) {
            Request req = new Request.Builder().url(authServer + "/.well-known/openid-configuration").get().build();
            String endpointsJson = httpClient.newCall(req).execute().body().string();
            config = parser.parse(endpointsJson).getAsJsonObject();
            discoveredConfigs.put(authServer, config);
        }
        return config;
    }

    private static X509Certificate loadCertificate(String certFilePath) throws CertificateException, FileNotFoundException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        return (X509Certificate) certificateFactory.generateCertificate(new FileInputStream(certFilePath));
    }

    private static Map<String, Object> parseClaims(String accessToken) throws ApiException {
        try {
            String body = accessToken.split("\\.")[1];
            String json = new String(Base64.decodeBase64(body), StandardCharsets.UTF_8);
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<HashMap<String,Object>> typeRef = new TypeReference<HashMap<String,Object>>() {};
            return objectMapper.readValue(json, typeRef);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ApiException("Invalid token structure. Not a JWT?");
        } catch (IOException e) {
            throw new ApiException(e);
        }
    }

    private static PrivateKey loadPrivateKey(String keyFilePath)
        throws IOException, ApiException, NoSuchAlgorithmException, InvalidKeySpecException {
        FileReader reader = new FileReader(keyFilePath);
        PemReader pemReader = new PemReader(reader);
        PemObject pemObject = pemReader.readPemObject();
        String type = pemObject.getType();
        final String PRIVATE_KEY_TYPE_SUFFIX = "PRIVATE KEY";
        if (!type.endsWith(PRIVATE_KEY_TYPE_SUFFIX)) {
            throw new ApiException("Invalid key file content - expecting first line similar to\n" +
                "-----BEGIN RSA PRIVATE KEY-----");
        }
        String algorithm = type.replace(PRIVATE_KEY_TYPE_SUFFIX, "").trim();
        if (StringUtils.isNotBlank(algorithm) && !"RSA".equals(algorithm)) {
            throw new ApiException("Invalid algorithm for MTLS: " + algorithm);
        }
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(pemObject.getContent());
        return generateRSAPrivateKey(keySpec);
    }

    private static PrivateKey generateRSAPrivateKey(KeySpec keySpec)
        throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(keySpec);
    }

    private static OkHttpClient buildHttpClient(OkHttpClient httpClient,
                                                X509Certificate rootCaCertificate,
                                                HeldCertificate heldCertificate,
                                                X509Certificate... intermediates) {
        HandshakeCertificates.Builder builder = new HandshakeCertificates.Builder()
            .addPlatformTrustedCertificates().addTrustedCertificate(rootCaCertificate);

        if (heldCertificate != null) {
            builder.heldCertificate(heldCertificate, intermediates);
        }

        HandshakeCertificates handshakeCertificates = builder.build();
        SSLSocketFactory sslSocketFactory = handshakeCertificates.sslSocketFactory();
        X509TrustManager trustManager = handshakeCertificates.trustManager();
        return httpClient.newBuilder().sslSocketFactory(sslSocketFactory, trustManager).build();
    }

    private static void validateClientCertSettings(ApiClientOptions clientOptions) throws ApiException {
        String rootCaFilePath = clientOptions.getRootCaFilePath();
        String certFilePath = clientOptions.getCertFilePath();
        String keyFilePath = clientOptions.getKeyFilePath();
        if (StringUtils.isBlank(rootCaFilePath)) {
            throw new ApiException("Root CA path is not set");
        }
        if (StringUtils.isBlank(certFilePath)) {
            throw new ApiException("Client certificate path is not set");
        }
        if (StringUtils.isBlank(keyFilePath)) {
            throw new ApiException("Client key file path is not set");
        }
        File rootCaFile = new File(rootCaFilePath);
        File certFile = new File(certFilePath);
        File keyFile = new File(keyFilePath);
        if (!rootCaFile.exists()) {
            throw new ApiException("Root CA file " + rootCaFilePath + " cannot be found");
        }
        if (!certFile.exists()) {
            throw new ApiException("Certificate file " + certFilePath + " cannot be found");
        }
        if (!keyFile.exists()) {
            throw new ApiException("Client key file " + keyFilePath + " cannot be found");
        }
    }

    private static void setProxy(ApiClient apiClient, String proxy) throws ApiException {
        OkHttpClient.Builder builder = apiClient.getHttpClient().newBuilder();
        if ("none".equalsIgnoreCase(proxy)) {
            builder.proxy(Proxy.NO_PROXY);
        } else {
            String[] typeAndOther = proxy.split("//");
            if (typeAndOther.length != 2) {
                printProxyExamples();
                throw new ApiException("Invalid proxy, please double check it.");
            }
            if (!VALID_PROXY_TYPES.contains(typeAndOther[0].toUpperCase())) {
                printProxyExamples();
                throw new ApiException("Invalid proxy, please double check it.");
            }
            String[] authAndOther = typeAndOther[1].split("@");
            if (authAndOther.length > 2) {
                printProxyExamples();
                throw new ApiException("Invalid proxy, please double check it.");
            }
            String[] hostAndPort = authAndOther[authAndOther.length - 1].split(":");
            if (hostAndPort.length != 2) {
                printProxyExamples();
                throw new ApiException("Invalid proxy, please double check it.");
            }
            String host = hostAndPort[0];
            String port = hostAndPort[1];
            if (!port.matches("[1-9]\\d*")) {
                printProxyExamples();
                throw new ApiException("Invalid proxy, please double check it.");
            }
            int portNumber = Integer.parseInt(port);
            builder.proxy(new Proxy(getProxyType(typeAndOther[0]), new InetSocketAddress(host, portNumber)));
            if (authAndOther.length > 1) {
                String[] userAndPass = authAndOther[0].split(":", 2);
                if (userAndPass.length != 2) {
                    printProxyExamples();
                    throw new ApiException("Invalid proxy, please double check it.");
                }
                okhttp3.Authenticator proxyAuthenticator = (route, response) -> {
                    String credential = Credentials.basic(userAndPass[0], userAndPass[1]);
                    return response.request().newBuilder()
                        .header("Proxy-Authorization", credential)
                        .build();
                };
                builder.proxyAuthenticator(proxyAuthenticator);
            }
        }
        apiClient.setHttpClient(builder.build());
    }

    private static Proxy.Type getProxyType(String type) {
        if (type.equalsIgnoreCase("socks:")) {
            return Proxy.Type.SOCKS;
        }
        return Proxy.Type.HTTP;
    }

    private static void printProxyExamples() {
        LOGGER.info("Valid proxy examples:");
        LOGGER.info("http://http.proxy:8080");
        LOGGER.info("https://https.proxy:8443");
        LOGGER.info("socks://socks.proxy:5500");
        LOGGER.info("http://user:pass@http.proxy:8080");
        LOGGER.info("https://user:pass@https.proxy:8443");
        LOGGER.info("socks://user:pass@socks.proxy:5500");
    }

    private static boolean isValidUrl(String url) {
        String lowerCaseUrl = url.toLowerCase();
        if (!lowerCaseUrl.startsWith("https://") && !lowerCaseUrl.startsWith("http://")) {
            LOGGER.error("Invalid scheme specified for server url, only https:// and http:// are supported");
            return false;
        }
        try {
            new URL(url);
            LOGGER.trace("Server URL of {} passes validation", url);
            return true;
        } catch (MalformedURLException e) {
            LOGGER.error("Specified URL of {} is malformed and exception caught: {}", url, e.getMessage());
            return false;
        }
    }
}
