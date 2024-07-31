package com.tyl.mca.cashadvanceservice.model.accounts.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@With
@AllArgsConstructor

public class AccountsResponse {

    @JsonProperty("Data")
    @Valid
    private AccountsResponseData data;

    @JsonProperty("Links")
    @Valid
    private Links links;

    @JsonProperty("Meta")
    @Valid
    private Meta meta;


}
