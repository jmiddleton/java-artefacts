/*
 * Consumer Data Standards
 * Sample Data Holder to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated by the cds-codegen package
 * https://github.com/ConsumerDataStandardsAustralia/cds-codegen
 * Do not edit the class manually.
 */
package au.org.consumerdatastandards.client.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/** BankingProductAdditionalInformation */
public class BankingProductAdditionalInformation {
  // General overview of the product
  @SerializedName("overviewUri")
  private String overviewUri;
  // Terms and conditions for the product
  @SerializedName("termsUri")
  private String termsUri;
  // Eligibility rules and criteria for the product
  @SerializedName("eligibilityUri")
  private String eligibilityUri;
  // Description of fees, pricing, discounts, exemptions and
  // bonuses for the product
  @SerializedName("feesAndPricingUri")
  private String feesAndPricingUri;
  // Description of a bundle that this product can be part of
  @SerializedName("bundleUri")
  private String bundleUri;

  @ApiModelProperty(value = "General overview of the product", required = false)
  public String getOverviewUri() {
    return overviewUri;
  }

  public void setOverviewUri(String overviewUri) {
    this.overviewUri = overviewUri;
  }

  public BankingProductAdditionalInformation overviewUri(String overviewUri) {
    this.overviewUri = overviewUri;
    return this;
  }

  @ApiModelProperty(value = "Terms and conditions for the product", required = false)
  public String getTermsUri() {
    return termsUri;
  }

  public void setTermsUri(String termsUri) {
    this.termsUri = termsUri;
  }

  public BankingProductAdditionalInformation termsUri(String termsUri) {
    this.termsUri = termsUri;
    return this;
  }

  @ApiModelProperty(value = "Eligibility rules and criteria for the product", required = false)
  public String getEligibilityUri() {
    return eligibilityUri;
  }

  public void setEligibilityUri(String eligibilityUri) {
    this.eligibilityUri = eligibilityUri;
  }

  public BankingProductAdditionalInformation eligibilityUri(String eligibilityUri) {
    this.eligibilityUri = eligibilityUri;
    return this;
  }

  @ApiModelProperty(
      value = "Description of fees, pricing, discounts, exemptions and bonuses for the product",
      required = false)
  public String getFeesAndPricingUri() {
    return feesAndPricingUri;
  }

  public void setFeesAndPricingUri(String feesAndPricingUri) {
    this.feesAndPricingUri = feesAndPricingUri;
  }

  public BankingProductAdditionalInformation feesAndPricingUri(String feesAndPricingUri) {
    this.feesAndPricingUri = feesAndPricingUri;
    return this;
  }

  @ApiModelProperty(
      value = "Description of a bundle that this product can be part of",
      required = false)
  public String getBundleUri() {
    return bundleUri;
  }

  public void setBundleUri(String bundleUri) {
    this.bundleUri = bundleUri;
  }

  public BankingProductAdditionalInformation bundleUri(String bundleUri) {
    this.bundleUri = bundleUri;
    return this;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    BankingProductAdditionalInformation inputModel = (BankingProductAdditionalInformation) o;
    if (!(overviewUri.equals(inputModel.getOverviewUri()))) {
      return false;
    }
    if (!(termsUri.equals(inputModel.getTermsUri()))) {
      return false;
    }
    if (!(eligibilityUri.equals(inputModel.getEligibilityUri()))) {
      return false;
    }
    if (!(feesAndPricingUri.equals(inputModel.getFeesAndPricingUri()))) {
      return false;
    }
    if (!(bundleUri.equals(inputModel.getBundleUri()))) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(bundleUri, bundleUri, bundleUri, bundleUri, bundleUri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("class %s {\n", getClass()));
    sb.append("    overviewUri: ").append(toIndentedString(overviewUri)).append("\n");
    sb.append("    termsUri: ").append(toIndentedString(termsUri)).append("\n");
    sb.append("    eligibilityUri: ").append(toIndentedString(eligibilityUri)).append("\n");
    sb.append("    feesAndPricingUri: ").append(toIndentedString(feesAndPricingUri)).append("\n");
    sb.append("    bundleUri: ").append(toIndentedString(bundleUri)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
