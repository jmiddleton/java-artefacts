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

public class LinksPaginated {

  /**
   * Fully qualified link to this API call
   */
  @SerializedName("self")
  private String self;

  /**
   * String to the first page of this set. Mandatory if this
   * response is not the first page
   */
  @SerializedName("first")
  private String first;

  /**
   * String to the previous page of this set. Mandatory if this
   * response is not the first page
   */
  @SerializedName("prev")
  private String prev;

  /**
   * String to the next page of this set. Mandatory if this response
   * is not the last page
   */
  @SerializedName("next")
  private String next;

  /**
   * String to the last page of this set. Mandatory if this response
   * is not the last page
   */
  @SerializedName("last")
  private String last;

  public String getSelf() {
    return self;
  }

  public void setSelf(String self) {
    this.self = self;
  }

  public LinksPaginated self(String self) {
    this.self = self;
    return this;
  }

  public String getFirst() {
    return first;
  }

  public void setFirst(String first) {
    this.first = first;
  }

  public LinksPaginated first(String first) {
    this.first = first;
    return this;
  }

  public String getPrev() {
    return prev;
  }

  public void setPrev(String prev) {
    this.prev = prev;
  }

  public LinksPaginated prev(String prev) {
    this.prev = prev;
    return this;
  }

  public String getNext() {
    return next;
  }

  public void setNext(String next) {
    this.next = next;
  }

  public LinksPaginated next(String next) {
    this.next = next;
    return this;
  }

  public String getLast() {
    return last;
  }

  public void setLast(String last) {
    this.last = last;
  }

  public LinksPaginated last(String last) {
    this.last = last;
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

    LinksPaginated inputModel = (LinksPaginated) o;
    if (!(self.equals(inputModel.getSelf()))) {
      return false;
    }
    if (!(first.equals(inputModel.getFirst()))) {
      return false;
    }
    if (!(prev.equals(inputModel.getPrev()))) {
      return false;
    }
    if (!(next.equals(inputModel.getNext()))) {
      return false;
    }
    return last.equals(inputModel.getLast());
  }

  @Override
  public int hashCode() {
    return Objects.hash(last, last, last, last, last);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("class %s {\n", getClass()));
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    first: ").append(toIndentedString(first)).append("\n");
    sb.append("    prev: ").append(toIndentedString(prev)).append("\n");
    sb.append("    next: ").append(toIndentedString(next)).append("\n");
    sb.append("    last: ").append(toIndentedString(last)).append("\n");
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
