package com.tyl.mca.cashadvanceservice.model.transaction.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChargeAmount {
    @JsonProperty("Amount")
    @NotNull
    @Pattern(regexp = "^\\d{1,13}\\.\\d{1,5}$")
    @Valid
    private String amount = null;

    @JsonProperty("Currency")
    @NotNull
    @Pattern(regexp = "^[A-Z]{3,3}$")
    @Valid
    private String currency = null;

    public ChargeAmount amount(String amount) {
        this.amount = amount;
        return this;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public ChargeAmount currency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Get currency
     *
     * @return currency
     **/
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChargeAmount chargeAmount = (ChargeAmount) o;
        return Objects.equals(this.amount, chargeAmount.amount) &&
                Objects.equals(this.currency, chargeAmount.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ChargeAmount {\n");

        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
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

