package com.tyl.mca.cashadvanceservice.model.accounts.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class Account {

    @JsonProperty("AccountId")
    @Valid
    @Size(min = 1, max = 40)
    private String accountId;

    @JsonProperty("Status")
    @Valid
    private String status;

    @JsonProperty("StatusUpdateDateTime")
    @Valid
    private String statusUpdateDateTime;

    @JsonProperty("Currency")
    @Valid
    @Pattern(regexp = "^[A-Z]{3,3}$")
    private String currency;

    @JsonProperty("AccountType")
    @Valid
    private AccountType accountType;

    @JsonProperty("AccountSubType")
    @Valid
    private String accountSubType;

    @JsonProperty("Description")
    @Valid
    @Size(min = 1, max = 35)
    private String description;

    @JsonProperty("Nickname")
    @Valid
    @Size(min = 1, max = 70)
    private String nickName;

    @JsonProperty("OpeningDate")
    @Valid
    private String openingDate;

    @JsonProperty("MaturityDate")
    @Valid
    private String maturityDate;

    @JsonProperty("Account")
    @Valid
    private List<AccountIdentificationDetails> accountIdentificationDetails;

}
