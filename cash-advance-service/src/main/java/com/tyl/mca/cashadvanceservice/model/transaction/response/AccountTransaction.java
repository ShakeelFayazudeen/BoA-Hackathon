package com.tyl.mca.cashadvanceservice.model.transaction.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
@With
public class AccountTransaction {

    @JsonProperty("AccountId")
    private String accountId;

    @JsonProperty("TransactionId")
    private String transactionId;

    @JsonProperty("CreditDebitIndicator")
    private String creditDebitIndicator;

    @JsonProperty("Status")
    private AccountTransactionStatus status;

    @JsonProperty("BookingDateTime")
    private String bookingDateTime;

    @JsonProperty("Amount")
    private ChargeAmount amount;

    @JsonProperty("ValueDateTime")
    private String valueDateTime;

    @JsonProperty("TransactionInformation")
    private String transactionInformation;

    @JsonProperty("AddressLine")
    private String addressLine;

    @JsonProperty("BankTransactionCode")
    private BankTransactionCode bankTransactionCode;

    @JsonProperty("ProprietaryBankTransactionCode")
    private ProprietaryBankTransactionCode proprietaryBankTransactionCode;

    @JsonProperty("Balance")
    private Balance balance;

    @JsonProperty("MerchantDetails")
    private MerchantDetails merchantDetails;

}
