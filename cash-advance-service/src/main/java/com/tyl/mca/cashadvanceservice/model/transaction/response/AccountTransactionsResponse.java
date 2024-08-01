package com.tyl.mca.cashadvanceservice.model.transaction.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountTransactionsResponse {

    @JsonProperty("Data")
    @Valid
    private AccountTransactionsResponseData data;

    @JsonProperty("Links")
    @Valid
    private Links links;

    @JsonProperty("Meta")
    @Valid
    private Meta meta;

    @JsonProperty("TotalTransactionAmount")
    @Valid
    private Double totalTransactionAmount;

    @JsonProperty("AverageTransactionPerMonth")
    @Valid
    private Double averageTransactionPerMonth;


}
