package com.tyl.mca.cashadvanceservice.model.transaction.response;

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
public class Meta {

    @JsonProperty("LastAvailableDateTime")
    @Valid
    private String lastAvailableDateTime;

    @JsonProperty("FirstAvailableDateTime")
    @Valid
    private String firstAvailableDateTime;

    @JsonProperty("TotalPages")
    @Valid
    private int totalPages;


}
