package com.tyl.mca.cashadvanceservice.model.consent.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class AccountAccessConsentPayloadData {


    @JsonProperty("Permissions")
    @NotEmpty
    @Valid
    private List<@NotNull Permissions> permissions;


}
