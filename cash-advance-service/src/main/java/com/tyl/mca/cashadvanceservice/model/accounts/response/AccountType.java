package com.tyl.mca.cashadvanceservice.model.accounts.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public enum AccountType {

    @JsonProperty("Business")
    BUSINESS,
    @JsonProperty("Personal")
    PERSONAL;

    public static AccountType valueOfIgnoringCase(String type){
        for (AccountType o : values()) {
            if(o.name().equalsIgnoreCase(type))
                return o;
        }
        return null;
    }

}
