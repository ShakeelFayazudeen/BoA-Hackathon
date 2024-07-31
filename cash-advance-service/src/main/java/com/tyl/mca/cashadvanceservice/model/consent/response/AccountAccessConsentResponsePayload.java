package com.tyl.mca.cashadvanceservice.model.consent.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountAccessConsentResponsePayload {

    @JsonProperty("Data")
    @Valid
    @NotNull
    private AccountAccessConsentResponsePayloadData data;

    @JsonProperty("Links")
    @Valid
    @NotNull
    private Links links;

    @JsonProperty("Meta")
    @Valid
    @NotNull
    private Meta meta;

    @JsonProperty("Risk")
    @Valid
    @NotNull
    private Risk risk;


}
