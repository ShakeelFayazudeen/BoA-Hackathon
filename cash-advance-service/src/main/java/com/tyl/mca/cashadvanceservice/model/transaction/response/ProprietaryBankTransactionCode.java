package com.tyl.mca.cashadvanceservice.model.transaction.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProprietaryBankTransactionCode {

    @JsonProperty("Code")
    private String code;

}
