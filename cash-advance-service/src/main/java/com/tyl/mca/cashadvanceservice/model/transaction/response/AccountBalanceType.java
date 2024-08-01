package com.tyl.mca.cashadvanceservice.model.transaction.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum AccountBalanceType {

    @JsonProperty("ClosingAvailable")
    CLOSINGAVAILABLE("ClosingAvailable"),

    @JsonProperty("ClosingBooked")
    CLOSINGBOOKED("ClosingBooked"),

    @JsonProperty("ClosingCleared")
    CLOSINGCLEARED("ClosingCleared"),

    @JsonProperty("Expected")
    EXPECTED("Expected"),

    @JsonProperty("ForwardAvailable")
    FORWARDAVAILABLE("ForwardAvailable"),

    @JsonProperty("Information")
    INFORMATION("Information"),

    @JsonProperty("InterimAvailable")
    INTERIMAVAILABLE("InterimAvailable"),

    @JsonProperty("InterimBooked")
    INTERIMBOOKED("InterimBooked"),

    @JsonProperty("InterimCleared")
    INTERIMCLEARED("InterimCleared"),

    @JsonProperty("OpeningAvailable")
    OPENINGAVAILABLE("OpeningAvailable"),

    @JsonProperty("OpeningBooked")
    OPENINGBOOKED("OpeningBooked"),

    @JsonProperty("OpeningCleared")
    OPENINGCLEARED("OpeningCleared"),

    @JsonProperty("PreviouslyClosedBooked")
    PREVIOUSLYCLOSEDBOOKED("PreviouslyClosedBooked");

    private final String value;

    AccountBalanceType(String value) {
        this.value = value;
    }

    public static AccountBalanceType fromValue(String text) {
        for (AccountBalanceType b : AccountBalanceType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

}
