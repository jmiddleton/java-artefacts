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

/** MetaPaginated */
public class MetaPaginated {
  // The total number of records in the full set
  @SerializedName("totalRecords")
  private Integer totalRecords;
  // The total number of pages in the full set
  @SerializedName("totalPages")
  private Integer totalPages;

  @ApiModelProperty(value = "The total number of records in the full set", required = true)
  public Integer getTotalRecords() {
    return totalRecords;
  }

  public void setTotalRecords(Integer totalRecords) {
    this.totalRecords = totalRecords;
  }

  public MetaPaginated totalRecords(Integer totalRecords) {
    this.totalRecords = totalRecords;
    return this;
  }

  @ApiModelProperty(value = "The total number of pages in the full set", required = true)
  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public MetaPaginated totalPages(Integer totalPages) {
    this.totalPages = totalPages;
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

    MetaPaginated inputModel = (MetaPaginated) o;
    if (!(totalRecords.equals(inputModel.getTotalRecords()))) {
      return false;
    }
    if (!(totalPages.equals(inputModel.getTotalPages()))) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalPages, totalPages);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("class %s {\n", getClass()));
    sb.append("    totalRecords: ").append(toIndentedString(totalRecords)).append("\n");
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
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
