package com.tyl.mca.cashadvanceservice.model.transaction.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum AccountTransactionStatus {

    @JsonProperty("Booked")
    BOOKED("Booked"),

    @JsonProperty("Pending")
    PENDING("Pending");

    private final String value;

    AccountTransactionStatus(String value) {
        this.value = value;
    }

    public static AccountTransactionStatus fromValue(String text) {
        for (AccountTransactionStatus b : AccountTransactionStatus.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
