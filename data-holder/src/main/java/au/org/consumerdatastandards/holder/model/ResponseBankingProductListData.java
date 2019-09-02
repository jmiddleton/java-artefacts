/*
 * Consumer Data Standards
 * Sample Data Holder to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated by the codegen artefact
 * https://github.com/ConsumerDataStandardsAustralia/java-artefacts/codegen
 * Do not edit the class manually.
 */
package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import java.lang.reflect.Field;
import java.util.List;




/**
* ResponseBankingProductListData
* 
* 
*/
public class ResponseBankingProductListData  {
    // The list of products returned.  If the filter results in an
    // empty set then this array may have no records
    @JsonProperty("products")
    private List<BankingProduct> products;

    
    public List<BankingProduct> getProducts() {
        return products;
    }

    public void setProducts(List<BankingProduct> products) {
        this.products = products;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        ResponseBankingProductListData inputModel = (ResponseBankingProductListData) o;
        if(! (products.equals(inputModel.getProducts()))) { return false; }
        return true;
    }

    @Override
    public int hashCode() {
      return Objects.hash(products);
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


}
