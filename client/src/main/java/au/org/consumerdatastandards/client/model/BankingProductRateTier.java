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
import java.math.BigDecimal;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/** BankingProductRateTier */
public class BankingProductRateTier {
  // A display name for the tier
  @SerializedName("name")
  private String name;
  // The unit of measure that applies to the tierValueMinimum and
  // tierValueMaximum values e.g. 'DOLLAR', 'MONTH' (in the case
  // of term deposit tiers), 'PERCENT' (in the case of
  // loan-to-value ratio or LVR)
  @SerializedName("unitOfMeasure")
  private UnitOfMeasure unitOfMeasure;
  // The number of tierUnitOfMeasure units that form the lower
  // bound of the tier. The tier should be inclusive of this
  // value
  @SerializedName("minimumValue")
  private BigDecimal minimumValue;
  // The number of tierUnitOfMeasure units that form the upper
  // bound of the tier or band. For a tier with a discrete value
  // (as opposed to a range of values e.g. 1 month) this must be
  // the same as tierValueMinimum. Where this is the same as the
  // tierValueMinimum value of the next-higher tier the
  // referenced tier should be exclusive of this value. For
  // example a term deposit of 2 months falls into the upper tier
  // of the following tiers: (1 – 2 months, 2 – 3 months). If
  // absent the tier's range has no upper bound.
  @SerializedName("maximumValue")
  private BigDecimal maximumValue;
  // The method used to calculate the amount to be applied using
  // one or more tiers. A single rate may be applied to the
  // entire balance or each applicable tier rate is applied to
  // the portion of the balance that falls into that tier
  // (referred to as 'bands' or 'steps')
  @SerializedName("rateApplicationMethod")
  private RateApplicationMethod rateApplicationMethod;

  @SerializedName("applicabilityConditions")
  private BankingProductRateCondition applicabilityConditions;

  @SerializedName("subTier")
  private BankingProductRateTierSubTier subTier;

  @ApiModelProperty(value = "A display name for the tier", required = true)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BankingProductRateTier name(String name) {
    this.name = name;
    return this;
  }

  @ApiModelProperty(
      value =
          "The unit of measure that applies to the tierValueMinimum and tierValueMaximum values e.g. 'DOLLAR', 'MONTH' (in the case of term deposit tiers), 'PERCENT' (in the case of loan-to-value ratio or LVR)",
      required = true)
  public UnitOfMeasure getUnitOfMeasure() {
    return unitOfMeasure;
  }

  public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }

  public BankingProductRateTier unitOfMeasure(UnitOfMeasure unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
    return this;
  }

  @ApiModelProperty(
      value =
          "The number of tierUnitOfMeasure units that form the lower bound of the tier. The tier should be inclusive of this value",
      required = true)
  public BigDecimal getMinimumValue() {
    return minimumValue;
  }

  public void setMinimumValue(BigDecimal minimumValue) {
    this.minimumValue = minimumValue;
  }

  public BankingProductRateTier minimumValue(BigDecimal minimumValue) {
    this.minimumValue = minimumValue;
    return this;
  }

  @ApiModelProperty(
      value =
          "The number of tierUnitOfMeasure units that form the upper bound of the tier or band. For a tier with a discrete value (as opposed to a range of values e.g. 1 month) this must be the same as tierValueMinimum. Where this is the same as the tierValueMinimum value of the next-higher tier the referenced tier should be exclusive of this value. For example a term deposit of 2 months falls into the upper tier of the following tiers: (1 – 2 months, 2 – 3 months). If absent the tier's range has no upper bound.",
      required = false)
  public BigDecimal getMaximumValue() {
    return maximumValue;
  }

  public void setMaximumValue(BigDecimal maximumValue) {
    this.maximumValue = maximumValue;
  }

  public BankingProductRateTier maximumValue(BigDecimal maximumValue) {
    this.maximumValue = maximumValue;
    return this;
  }

  @ApiModelProperty(
      value =
          "The method used to calculate the amount to be applied using one or more tiers. A single rate may be applied to the entire balance or each applicable tier rate is applied to the portion of the balance that falls into that tier (referred to as 'bands' or 'steps')",
      required = false)
  public RateApplicationMethod getRateApplicationMethod() {
    return rateApplicationMethod;
  }

  public void setRateApplicationMethod(RateApplicationMethod rateApplicationMethod) {
    this.rateApplicationMethod = rateApplicationMethod;
  }

  public BankingProductRateTier rateApplicationMethod(RateApplicationMethod rateApplicationMethod) {
    this.rateApplicationMethod = rateApplicationMethod;
    return this;
  }

  @ApiModelProperty(value = "", required = false)
  public BankingProductRateCondition getApplicabilityConditions() {
    return applicabilityConditions;
  }

  public void setApplicabilityConditions(BankingProductRateCondition applicabilityConditions) {
    this.applicabilityConditions = applicabilityConditions;
  }

  public BankingProductRateTier applicabilityConditions(
      BankingProductRateCondition applicabilityConditions) {
    this.applicabilityConditions = applicabilityConditions;
    return this;
  }

  @ApiModelProperty(value = "", required = false)
  public BankingProductRateTierSubTier getSubTier() {
    return subTier;
  }

  public void setSubTier(BankingProductRateTierSubTier subTier) {
    this.subTier = subTier;
  }

  public BankingProductRateTier subTier(BankingProductRateTierSubTier subTier) {
    this.subTier = subTier;
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

    BankingProductRateTier inputModel = (BankingProductRateTier) o;
    if (!(name.equals(inputModel.getName()))) {
      return false;
    }
    if (!(unitOfMeasure.equals(inputModel.getUnitOfMeasure()))) {
      return false;
    }
    if (!(minimumValue.equals(inputModel.getMinimumValue()))) {
      return false;
    }
    if (!(maximumValue.equals(inputModel.getMaximumValue()))) {
      return false;
    }
    if (!(rateApplicationMethod.equals(inputModel.getRateApplicationMethod()))) {
      return false;
    }
    if (!(applicabilityConditions.equals(inputModel.getApplicabilityConditions()))) {
      return false;
    }
    if (!(subTier.equals(inputModel.getSubTier()))) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(subTier, subTier, subTier, subTier, subTier, subTier, subTier);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("class %s {\n", getClass()));
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
    sb.append("    minimumValue: ").append(toIndentedString(minimumValue)).append("\n");
    sb.append("    maximumValue: ").append(toIndentedString(maximumValue)).append("\n");
    sb.append("    rateApplicationMethod: ")
        .append(toIndentedString(rateApplicationMethod))
        .append("\n");
    sb.append("    applicabilityConditions: ")
        .append(toIndentedString(applicabilityConditions))
        .append("\n");
    sb.append("    subTier: ").append(toIndentedString(subTier)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  /** RateApplicationMethod */
  @JsonAdapter(RateApplicationMethod.Adapter.class)
  public enum RateApplicationMethod {
    WHOLE_BALANCE("WHOLE_BALANCE"),
    PER_TIER("PER_TIER");

    private String value;

    RateApplicationMethod(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public String getValue() {
      return value;
    }

    public static RateApplicationMethod fromValue(String value) {
      for (RateApplicationMethod b : RateApplicationMethod.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<RateApplicationMethod> {
      @Override
      public void write(final JsonWriter jsonWriter, final RateApplicationMethod enumeration)
          throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RateApplicationMethod read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return RateApplicationMethod.fromValue(value);
      }
    }
  }

  /** UnitOfMeasure */
  @JsonAdapter(UnitOfMeasure.Adapter.class)
  public enum UnitOfMeasure {
    DOLLAR("DOLLAR"),
    PERCENT("PERCENT"),
    MONTH("MONTH"),
    DAY("DAY");

    private String value;

    UnitOfMeasure(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public String getValue() {
      return value;
    }

    public static UnitOfMeasure fromValue(String value) {
      for (UnitOfMeasure b : UnitOfMeasure.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<UnitOfMeasure> {
      @Override
      public void write(final JsonWriter jsonWriter, final UnitOfMeasure enumeration)
          throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public UnitOfMeasure read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return UnitOfMeasure.fromValue(value);
      }
    }
  }
}
