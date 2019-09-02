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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public class BankingProductConstraint {

  /**
   * The type of constraint described.  See the next section for
   * an overview of valid values and their meaning
   */
  @SerializedName("constraintType")
  private ConstraintType constraintType;

  /**
   * Generic field containing additional information relevant to
   * the constraintType specified.  Whether mandatory or not is
   * dependent on the value of constraintType
   */
  @SerializedName("additionalValue")
  private String additionalValue;

  /**
   * Display text providing more information the constraint
   */
  @SerializedName("additionalInfo")
  private String additionalInfo;

  /**
   * Link to a web page with more information on the constraint
   */
  @SerializedName("additionalInfoUri")
  private String additionalInfoUri;

  public ConstraintType getConstraintType() {
    return constraintType;
  }

  public void setConstraintType(ConstraintType constraintType) {
    this.constraintType = constraintType;
  }

  public BankingProductConstraint constraintType(ConstraintType constraintType) {
    this.constraintType = constraintType;
    return this;
  }

  public String getAdditionalValue() {
    return additionalValue;
  }

  public void setAdditionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
  }

  public BankingProductConstraint additionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
    return this;
  }

  public String getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public BankingProductConstraint additionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  public String getAdditionalInfoUri() {
    return additionalInfoUri;
  }

  public void setAdditionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
  }

  public BankingProductConstraint additionalInfoUri(String additionalInfoUri) {
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

    BankingProductConstraint inputModel = (BankingProductConstraint) o;
    if (!(constraintType.equals(inputModel.getConstraintType()))) {
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
    sb.append("    constraintType: ").append(toIndentedString(constraintType)).append("\n");
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

  /** ConstraintType */
  @JsonAdapter(ConstraintType.Adapter.class)
  public enum ConstraintType {
    MIN_BALANCE("MIN_BALANCE"),
    MAX_BALANCE("MAX_BALANCE"),
    OPENING_BALANCE("OPENING_BALANCE"),
    MAX_LIMIT("MAX_LIMIT"),
    MIN_LIMIT("MIN_LIMIT");

    private String value;

    ConstraintType(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public String getValue() {
      return value;
    }

    public static ConstraintType fromValue(String value) {
      for (ConstraintType b : ConstraintType.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ConstraintType> {
      @Override
      public void write(final JsonWriter jsonWriter, final ConstraintType enumeration)
          throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ConstraintType read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ConstraintType.fromValue(value);
      }
    }
  }
}
