package com.tyl.mca.cashadvanceservice.model.transaction.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class BankTransactionCode {

    @JsonProperty("Code")
    private String code;

    @JsonProperty("SubCode")
    private String subCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankTransactionCode that = (BankTransactionCode) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(subCode, that.subCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, subCode);
    }

    @Override
    public String toString() {
        return "BankTransactionCode{" +
                "code='" + code + '\'' +
                ", subCode='" + subCode + '\'' +
                '}';
    }
}
