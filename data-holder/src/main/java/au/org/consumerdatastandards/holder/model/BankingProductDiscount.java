/*
 * Consumer Data Standards
 * Sample Data Holder to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated by the codegen artefact
 * https://github.com/ConsumerDataStandardsAustralia/java-artefacts/codegen
 * Do not edit the class manually.
 */
package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.Objects;
import java.net.URI;
import java.lang.reflect.Field;
import java.util.List;
import java.math.BigDecimal;

/**
 * BankingProductDiscount
 * 
 * 
 */
@Entity
public class BankingProductDiscount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productDiscountId;

    // Description of the discount
    @JsonProperty("description")
    @Column(length = 2048)
    private String description;
    // The type of discount. See the next section for an overview
    // of valid values and their meaning
    @JsonProperty("discountType")
    private DiscountType discountType;
    // Value of the discount
    @JsonProperty("amount")
    private BigDecimal amount;
    // A discount rate calculated based on a proportion of the
    // balance. Note that the currency of the fee discount is
    // expected to be the same as the currency of the fee itself.
    // One of amount, balanceRate, transactionRate, accruedRate and
    // feeRate is mandatory. Unless noted in additionalInfo,
    // assumes the application and calculation frequency are the
    // same as the corresponding fee
    @JsonProperty("balanceRate")
    private BigDecimal balanceRate;
    // A discount rate calculated based on a proportion of a
    // transaction. Note that the currency of the fee discount is
    // expected to be the same as the currency of the fee itself.
    // One of amount, balanceRate, transactionRate, accruedRate and
    // feeRate is mandatory
    @JsonProperty("transactionRate")
    private BigDecimal transactionRate;
    // A discount rate calculated based on a proportion of the
    // calculated interest accrued on the account. Note that the
    // currency of the fee discount is expected to be the same as
    // the currency of the fee itself. One of amount, balanceRate,
    // transactionRate, accruedRate and feeRate is mandatory.
    // Unless noted in additionalInfo, assumes the application and
    // calculation frequency are the same as the corresponding fee
    @JsonProperty("accruedRate")
    private BigDecimal accruedRate;
    // A discount rate calculated based on a proportion of the fee
    // to which this discount is attached. Note that the currency
    // of the fee discount is expected to be the same as the
    // currency of the fee itself. One of amount, balanceRate,
    // transactionRate, accruedRate and feeRate is mandatory.
    // Unless noted in additionalInfo, assumes the application and
    // calculation frequency are the same as the corresponding fee
    @JsonProperty("feeRate")
    private BigDecimal feeRate;
    // Generic field containing additional information relevant to
    // the discountType specified. Whether mandatory or not is
    // dependent on the value of discountType
    @JsonProperty("additionalValue")
    @Column(length = 2048)
    private String additionalValue;
    // Display text providing more information on the discount
    @JsonProperty("additionalInfo")
    @Column(length = 2048)
    private String additionalInfo;
    // Link to a web page with more information on this discount
    @JsonProperty("additionalInfoUri")
    private URI additionalInfoUri;
    // Eligibility constraints that apply to this discount
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_discount_eligibility", joinColumns = @JoinColumn(name = "product_discount_id"), inverseJoinColumns = @JoinColumn(name = "discount_eligibility_id"))
    @JsonProperty("eligibility")
    @Valid
    private List<BankingProductDiscountEligibility> eligibility;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalanceRate() {
        return balanceRate;
    }

    public void setBalanceRate(BigDecimal balanceRate) {
        this.balanceRate = balanceRate;
    }

    public BigDecimal getTransactionRate() {
        return transactionRate;
    }

    public void setTransactionRate(BigDecimal transactionRate) {
        this.transactionRate = transactionRate;
    }

    public BigDecimal getAccruedRate() {
        return accruedRate;
    }

    public void setAccruedRate(BigDecimal accruedRate) {
        this.accruedRate = accruedRate;
    }

    public BigDecimal getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(BigDecimal feeRate) {
        this.feeRate = feeRate;
    }

    public String getAdditionalValue() {
        return additionalValue;
    }

    public void setAdditionalValue(String additionalValue) {
        this.additionalValue = additionalValue;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public URI getAdditionalInfoUri() {
        return additionalInfoUri;
    }

    public void setAdditionalInfoUri(URI additionalInfoUri) {
        this.additionalInfoUri = additionalInfoUri;
    }

    public List<BankingProductDiscountEligibility> getEligibility() {
        return eligibility;
    }

    public void setEligibility(List<BankingProductDiscountEligibility> eligibility) {
        this.eligibility = eligibility;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BankingProductDiscount inputModel = (BankingProductDiscount) o;
        if (!(description.equals(inputModel.getDescription()))) {
            return false;
        }
        if (!(discountType.equals(inputModel.getDiscountType()))) {
            return false;
        }
        if (!(amount.equals(inputModel.getAmount()))) {
            return false;
        }
        if (!(balanceRate.equals(inputModel.getBalanceRate()))) {
            return false;
        }
        if (!(transactionRate.equals(inputModel.getTransactionRate()))) {
            return false;
        }
        if (!(accruedRate.equals(inputModel.getAccruedRate()))) {
            return false;
        }
        if (!(feeRate.equals(inputModel.getFeeRate()))) {
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
        if (!(eligibility.equals(inputModel.getEligibility()))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eligibility, eligibility, eligibility, eligibility, eligibility, eligibility, eligibility,
                eligibility, eligibility, eligibility, eligibility);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("class %s {\n", getClass()));

        for (Field oneField : getClass().getFields()) {
            oneField.setAccessible(true);
            try {
                sb.append(String.format("    %s: %s\n", oneField.getName(), (oneField.get(Object.class) == null ? "null"
                        : oneField.get(Object.class).toString().replace("\n", "\n    "))));
            } catch (IllegalArgumentException | IllegalAccessException e) {
                // I guess we won't print it
                sb.append(String.format("    %s, [unreadable]\n", oneField.getName()));
            }
        }
        sb.append("}");
        return sb.toString();
    }

    /**
     * DiscountType
     * 
     * 
     */
    public enum DiscountType {
        BALANCE("BALANCE"), DEPOSITS("DEPOSITS"), PAYMENTS("PAYMENTS"), FEE_CAP("FEE_CAP"),
        ELIGIBILITY_ONLY("ELIGIBILITY_ONLY");

        private String value;

        DiscountType(String value) {
            this.value = value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static DiscountType fromValue(String value) {
            for (DiscountType b : DiscountType.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

}
