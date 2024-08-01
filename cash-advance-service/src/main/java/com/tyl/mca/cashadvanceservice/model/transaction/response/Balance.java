package com.tyl.mca.cashadvanceservice.model.transaction.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Balance {

    @JsonProperty("Amount")
    private ChargeAmount amount;

    @JsonProperty("CreditDebitIndicator")
    private String creditDebitIndicator;

    @JsonProperty("Type")
    private AccountBalanceType type;

    public ChargeAmount getAmount() {
        return amount;
    }

    public void setAmount(ChargeAmount amount) {
        this.amount = amount;
    }

    public String getCreditDebitIndicator() {
        return creditDebitIndicator;
    }

    public void setCreditDebitIndicator(String creditDebitIndicator) {
        this.creditDebitIndicator = creditDebitIndicator;
    }

    public AccountBalanceType getType() {
        return type;
    }

    public void setType(AccountBalanceType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance balance = (Balance) o;
        return Objects.equals(amount, balance.amount) &&
                Objects.equals(creditDebitIndicator, balance.creditDebitIndicator) &&
                type == balance.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, creditDebitIndicator, type);
    }

    @Override
    public String toString() {
        return "Balance{" +
                "amount=" + amount +
                ", creditDebitIndicator='" + creditDebitIndicator + '\'' +
                ", type=" + type +
                '}';
    }
}
