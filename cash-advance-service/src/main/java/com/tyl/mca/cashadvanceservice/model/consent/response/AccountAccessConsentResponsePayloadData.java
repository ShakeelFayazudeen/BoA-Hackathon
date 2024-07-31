package com.tyl.mca.cashadvanceservice.model.consent.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tyl.mca.cashadvanceservice.model.consent.request.Permissions;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountAccessConsentResponsePayloadData {

    @JsonProperty("ConsentId")
    @Valid
    @NotNull
    @Size(min = 1, max = 128)
    private String consentId;

    @JsonProperty("CreationDateTime")
    @Valid
    @NotNull
    private String creationDateTime;

    @JsonProperty("Permissions")
    @NotEmpty
    @Valid
    private List<@NotNull Permissions> permissions;

    @JsonProperty("Status")
    @Valid
    @NotNull
    private ConsentStatus status;

    @JsonProperty("StatusUpdateDateTime")
    @Valid
    @NotNull
    private String statusUpdateDateTime;


}
