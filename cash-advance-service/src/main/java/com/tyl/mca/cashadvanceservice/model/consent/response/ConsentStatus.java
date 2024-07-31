package com.tyl.mca.cashadvanceservice.model.consent.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public enum ConsentStatus {
    Authorised,
    AwaitingAuthorisation,
    Revoked,
    Rejected;


}
