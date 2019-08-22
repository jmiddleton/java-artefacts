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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/** BankingProductDiscountEligibility */
public class BankingProductDiscountEligibility {
  // The type of the specific eligibility constraint for a
  // discount
  @SerializedName("discountEligibilityType")
  private DiscountEligibilityType discountEligibilityType;
  // Generic field containing additional information relevant to
  // the discountEligibilityType specified. Whether mandatory or
  // not is dependent on the value of discountEligibilityType
  @SerializedName("additionalValue")
  private String additionalValue;
  // Display text providing more information on this eligibility
  // constraint
  @SerializedName("additionalInfo")
  private String additionalInfo;
  // Link to a web page with more information on this eligibility
  // constraint
  @SerializedName("additionalInfoUri")
  private String additionalInfoUri;

  @ApiModelProperty(
      value = "The type of the specific eligibility constraint for a discount",
      required = true)
  public DiscountEligibilityType getDiscountEligibilityType() {
    return discountEligibilityType;
  }

  public void setDiscountEligibilityType(DiscountEligibilityType discountEligibilityType) {
    this.discountEligibilityType = discountEligibilityType;
  }

  public BankingProductDiscountEligibility discountEligibilityType(
      DiscountEligibilityType discountEligibilityType) {
    this.discountEligibilityType = discountEligibilityType;
    return this;
  }

  @ApiModelProperty(
      value =
          "Generic field containing additional information relevant to the discountEligibilityType specified. Whether mandatory or not is dependent on the value of discountEligibilityType",
      required = false)
  public String getAdditionalValue() {
    return additionalValue;
  }

  public void setAdditionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
  }

  public BankingProductDiscountEligibility additionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
    return this;
  }

  @ApiModelProperty(
      value = "Display text providing more information on this eligibility constraint",
      required = false)
  public String getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public BankingProductDiscountEligibility additionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  @ApiModelProperty(
      value = "Link to a web page with more information on this eligibility constraint",
      required = false)
  public String getAdditionalInfoUri() {
    return additionalInfoUri;
  }

  public void setAdditionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
  }

  public BankingProductDiscountEligibility additionalInfoUri(String additionalInfoUri) {
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

    BankingProductDiscountEligibility inputModel = (BankingProductDiscountEligibility) o;
    if (!(discountEligibilityType.equals(inputModel.getDiscountEligibilityType()))) {
      return false;
    }
    if (!(additionalValue.equals(inputModel.getAdditionalValue()))) {
      return false;
    }
    if (!(additionalInfo.equals(inputModel.getAdditionalInfo()))) {
      return false;
    }
    if (!(additionalInfoUri.equals(inputModel.getAdditionalInfoUri()))) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfoUri, additionalInfoUri, additionalInfoUri, additionalInfoUri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("class %s {\n", getClass()));
    sb.append("    discountEligibilityType: ")
        .append(toIndentedString(discountEligibilityType))
        .append("\n");
    sb.append("    additionalValue: ").append(toIndentedString(additionalValue)).append("\n");
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

  /** DiscountEligibilityType */
  @JsonAdapter(DiscountEligibilityType.Adapter.class)
  public enum DiscountEligibilityType {
    BUSINESS("BUSINESS"),
    PENSION_RECIPIENT("PENSION_RECIPIENT"),
    MIN_AGE("MIN_AGE"),
    MAX_AGE("MAX_AGE"),
    MIN_INCOME("MIN_INCOME"),
    MIN_TURNOVER("MIN_TURNOVER"),
    STAFF("STAFF"),
    STUDENT("STUDENT"),
    EMPLOYMENT_STATUS("EMPLOYMENT_STATUS"),
    RESIDENCY_STATUS("RESIDENCY_STATUS"),
    NATURAL_PERSON("NATURAL_PERSON"),
    INTRODUCTORY("INTRODUCTORY"),
    OTHER("OTHER");

    private String value;

    DiscountEligibilityType(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public String getValue() {
      return value;
    }

    public static DiscountEligibilityType fromValue(String value) {
      for (DiscountEligibilityType b : DiscountEligibilityType.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<DiscountEligibilityType> {
      @Override
      public void write(final JsonWriter jsonWriter, final DiscountEligibilityType enumeration)
          throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public DiscountEligibilityType read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return DiscountEligibilityType.fromValue(value);
      }
    }
  }
}
