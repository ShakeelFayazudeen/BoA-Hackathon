package com.tyl.mca.cashadvanceservice.model.consent.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tyl.mca.cashadvanceservice.model.consent.response.Risk;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@With
@ToString
public class AccountAccessConsentPayload {

    @Valid
    @NotNull
    @JsonProperty("Data")
    private AccountAccessConsentPayloadData data;

    @JsonProperty("Risk")
    @Valid
    @NotNull
    private Risk risk;

}
