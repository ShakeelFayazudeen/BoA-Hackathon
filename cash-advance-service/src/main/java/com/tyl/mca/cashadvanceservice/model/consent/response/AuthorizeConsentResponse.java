package com.tyl.mca.cashadvanceservice.model.consent.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizeConsentResponse {

    @JsonProperty("redirectUri")
    @Valid
    private String redirectUri;
}
