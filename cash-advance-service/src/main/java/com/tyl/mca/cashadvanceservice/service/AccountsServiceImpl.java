package com.tyl.mca.cashadvanceservice.service;

import com.tyl.mca.cashadvanceservice.model.RefreshTokenResponse;
import com.tyl.mca.cashadvanceservice.model.TokenResponse;
import com.tyl.mca.cashadvanceservice.model.accounts.response.AccountsResponse;
import com.tyl.mca.cashadvanceservice.model.consent.request.AccountAccessConsentPayload;
import com.tyl.mca.cashadvanceservice.model.consent.request.AccountAccessConsentPayloadData;
import com.tyl.mca.cashadvanceservice.model.consent.request.Permissions;
import com.tyl.mca.cashadvanceservice.model.consent.response.AccountAccessConsentResponsePayload;
import com.tyl.mca.cashadvanceservice.model.consent.response.AuthorizeConsentPayload;
import com.tyl.mca.cashadvanceservice.model.consent.response.AuthorizeConsentResponse;
import com.tyl.mca.cashadvanceservice.model.consent.response.Risk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static com.tyl.mca.cashadvanceservice.Constants.AMPERSAND;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Service
public class AccountsServiceImpl implements AccountsService {

    @Value("${boa.accountsUrl}")
    private String boaAccountsUrl;

    @Autowired
    private ConsentService consentService;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public AccountsResponse getAccounts(String token) {

        System.out.println("Token :"+ token);

        HttpHeaders headers = new HttpHeaders();
        headers.add(AUTHORIZATION, token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<AccountsResponse> response = restTemplate.exchange(boaAccountsUrl, HttpMethod.GET,
                requestEntity, AccountsResponse.class);

        return response.getBody();
    }

    @Override
    public AccountsResponse getAccountsChain() throws URISyntaxException {
        TokenResponse tokenResponse = consentService.fetchToken();
        System.out.println("Token Response: " + tokenResponse.getAccessToken());

        AccountAccessConsentPayload consentPayload = new AccountAccessConsentPayload()
                .withData(new AccountAccessConsentPayloadData(
                        List.of(Permissions.ReadAccountsDetail, Permissions.ReadTransactionsDetail,
                                Permissions.ReadTransactionsCredits, Permissions.ReadTransactionsDebits,
                                Permissions.ReadTransactionsDetail)))
                .withRisk(new Risk());

        AccountAccessConsentResponsePayload consentResponse = consentService.createConsent(consentPayload, "Bearer " + tokenResponse.getAccessToken());
        AuthorizeConsentResponse authorizeResponse = consentService.authorize(new AuthorizeConsentPayload().withConsentId(consentResponse.getData().getConsentId()));

        URI urlFragment = new URI(authorizeResponse.getRedirectUri());
        String codeWithQuery = urlFragment.getFragment().split(AMPERSAND)[0];
        String code = codeWithQuery.split("=")[1];

        System.out.println("Code : " + code);

        RefreshTokenResponse refreshTokenResponse = consentService.fetchRefreshToken(code);
        System.out.println("Refresh Token Response: " + refreshTokenResponse.getAccessToken());

        HttpHeaders headers = new HttpHeaders();
        headers.add(AUTHORIZATION, "Bearer " + refreshTokenResponse.getAccessToken());
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<AccountsResponse> response = restTemplate.exchange(boaAccountsUrl, HttpMethod.GET,
                requestEntity, AccountsResponse.class);

        return response.getBody();
    }
}
