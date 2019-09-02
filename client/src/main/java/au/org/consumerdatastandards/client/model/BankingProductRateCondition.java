/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated by the codegen artefact
 * https://github.com/ConsumerDataStandardsAustralia/java-artefacts/codegen
 * Do not edit the class manually.
 */
package au.org.consumerdatastandards.client.model;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

public class BankingProductRateCondition {

  /**
   // Display text providing more information on the condition
   */
  @SerializedName("additionalInfo")
  private String additionalInfo;

  /**
   // Link to a web page with more information on this condition
   */
  @SerializedName("additionalInfoUri")
  private String additionalInfoUri;

  public String getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public BankingProductRateCondition additionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  public String getAdditionalInfoUri() {
    return additionalInfoUri;
  }

  public void setAdditionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
  }

  public BankingProductRateCondition additionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
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

    BankingProductRateCondition inputModel = (BankingProductRateCondition) o;
    if (!(additionalInfo.equals(inputModel.getAdditionalInfo()))) {
      return false;
    }
    return additionalInfoUri.equals(inputModel.getAdditionalInfoUri());
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfoUri, additionalInfoUri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("class %s {\n", getClass()));
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    additionalInfoUri: ").append(toIndentedString(additionalInfoUri)).append("\n");
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
