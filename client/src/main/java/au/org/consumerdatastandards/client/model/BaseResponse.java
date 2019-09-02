/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated by the codegen artefact
 * https:*github.com/ConsumerDataStandardsAustralia/cds-codegen
 * Do not edit the class manually.
 */
package au.org.consumerdatastandards.client.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class BaseResponse {

  /**
   * The links attribute contains a Links object with links to
   * related API end points. This will include links to support
   * pagination.
   */
  @SerializedName("links")
  private Links links;

  /**
   * The meta object is used to provide additional information
   * such as second factor authorisation data, traffic
   * management, pagination counts or other purposes that are
   * complementary to the workings of the API.
   */
  @SerializedName("meta")
  private Meta meta;

  public Links getLinks() {
    return links;
  }

  public void setLinks(Links links) {
    this.links = links;
  }

  public BaseResponse links(Links links) {
    this.links = links;
    return this;
  }

  public Meta getMeta() {
    return meta;
  }

  public void setMeta(Meta meta) {
    this.meta = meta;
  }

  public BaseResponse meta(Meta meta) {
    this.meta = meta;
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

    BaseResponse inputModel = (BaseResponse) o;
    if (!(links.equals(inputModel.getLinks()))) {
      return false;
    }
    return meta.equals(inputModel.getMeta());
  }

  @Override
  public int hashCode() {
    return Objects.hash(meta, meta);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("class %s {\n", getClass()));
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
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
