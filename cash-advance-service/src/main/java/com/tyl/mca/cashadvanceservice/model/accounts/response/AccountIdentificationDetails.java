package com.tyl.mca.cashadvanceservice.model.accounts.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class AccountIdentificationDetails {

    @JsonProperty("SchemeName")
    @Valid
    @Size(min = 1, max = 40)
    private String schemeName;

    @JsonProperty("Identification")
    @Valid
    @Size(min = 1, max = 256)
    private String identification;

    @JsonProperty("Name")
    @Valid
    @Size(min = 1, max = 350)
    private String name;

    @JsonProperty("SecondaryIdentification")
    @Valid
    @Size(min = 1, max = 34)
    private String secondaryIdentification;


}
