package com.tyl.mca.cashadvanceservice.model.accounts.response;

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
public class Links {

    @JsonProperty("Last")
    @Valid
    private String last;

    @JsonProperty("Prev")
    @Valid
    private String prev;

    @JsonProperty("Next")
    @Valid
    private String next;

    @JsonProperty("Self")
    @Valid
    @NotNull
    private String self;

    @JsonProperty("First")
    @Valid
    private String first;


}
