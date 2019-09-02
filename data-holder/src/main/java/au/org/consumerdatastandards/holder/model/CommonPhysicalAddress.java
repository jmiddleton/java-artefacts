/*
 * Consumer Data Standards
 * Sample Data Holder to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated by the codegen artefact
 * https://github.com/ConsumerDataStandardsAustralia/java-artefacts/codegen
 * Do not edit the class manually.
 */
package au.org.consumerdatastandards.holder.model;

import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.persistence.*;
import java.util.Objects;
import java.lang.reflect.Field;




/**
* CommonPhysicalAddress
* 
* 
*/
@Entity
public class CommonPhysicalAddress  {
    
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    private String physicalAddressId;
    
    // The type of address object present
    @JsonProperty("addressUType")
    private AddressUType addressUType;
    @JsonProperty("simple")
    @OneToOne
    private CommonSimpleAddress simple = null;
    @JsonProperty("paf")
    @OneToOne
    private CommonPAFAddress paf = null;

    
    public AddressUType getAddressUType() {
        return addressUType;
    }

    public void setAddressUType(AddressUType addressUType) {
        this.addressUType = addressUType;
    }
    
    public CommonSimpleAddress getSimple() {
        return simple;
    }

    public void setSimple(CommonSimpleAddress simple) {
        this.simple = simple;
    }
    
    public CommonPAFAddress getPaf() {
        return paf;
    }

    public void setPaf(CommonPAFAddress paf) {
        this.paf = paf;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        CommonPhysicalAddress inputModel = (CommonPhysicalAddress) o;
        if(! (addressUType.equals(inputModel.getAddressUType()))) { return false; }
        if(! (simple.equals(inputModel.getSimple()))) { return false; }
        if(! (paf.equals(inputModel.getPaf()))) { return false; }
        return true;
    }

    @Override
    public int hashCode() {
      return Objects.hash(paf,paf,paf);
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
* AddressUType
* 
* 
*/
public enum AddressUType {
    SIMPLE("SIMPLE"),
    PAF("PAF");
    
    private String value;
    
    AddressUType(String value) {
      this.value = value;
    }
    
    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AddressUType fromValue(String value) {
      for (AddressUType b : AddressUType.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}




}
