package com.tyl.mca.cashadvanceservice.service;

import com.tyl.mca.cashadvanceservice.model.RefreshTokenResponse;
import com.tyl.mca.cashadvanceservice.model.TokenResponse;
import com.tyl.mca.cashadvanceservice.model.consent.request.AccountAccessConsentPayload;
import com.tyl.mca.cashadvanceservice.model.consent.response.AccountAccessConsentResponsePayload;
import com.tyl.mca.cashadvanceservice.model.consent.response.AuthorizeConsentPayload;
import com.tyl.mca.cashadvanceservice.model.consent.response.AuthorizeConsentResponse;

public interface ConsentService {

    TokenResponse fetchToken();

    AccountAccessConsentResponsePayload createConsent(AccountAccessConsentPayload payload, String token);

    AuthorizeConsentResponse authorize(AuthorizeConsentPayload payload);

    RefreshTokenResponse fetchRefreshToken(String code);
}
