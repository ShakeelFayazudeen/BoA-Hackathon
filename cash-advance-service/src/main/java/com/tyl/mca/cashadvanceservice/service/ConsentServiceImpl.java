package com.tyl.mca.cashadvanceservice.service;

import com.tyl.mca.cashadvanceservice.model.RefreshTokenResponse;
import com.tyl.mca.cashadvanceservice.model.TokenResponse;
import com.tyl.mca.cashadvanceservice.model.consent.request.AccountAccessConsentPayload;
import com.tyl.mca.cashadvanceservice.model.consent.response.AccountAccessConsentResponsePayload;
import com.tyl.mca.cashadvanceservice.model.consent.response.AuthorizeConsentPayload;
import com.tyl.mca.cashadvanceservice.model.consent.response.AuthorizeConsentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static com.tyl.mca.cashadvanceservice.Constants.*;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Service
public class ConsentServiceImpl implements ConsentService {

    @Value("${boa.consent.url}")
    private String boaConsentUrl;

    @Value("${boa.token.url}")
    private String boaTokenUrl;

    @Value("${boa.authorization.url}")
    private String authorizeUrl;

    @Value("${boa.clientId}")
    private String clientId;

    @Value("${boa.clientSecret}")
    private String clientSecret;

    @Value("${boa.consentGrantType}")
    private String grantType;

    @Value("${boa.consentScope}")
    private String scope;

    @Value("${boa.responseType}")
    private String responseType;

    @Value("${boa.authorizeScope}")
    private String authorizeScope;

    @Value("${boa.redirectUrl}")
    private String redirectUrl;

    @Value("${boa.state}")
    private String state;

    @Value("${boa.authorizationMode}")
    private String authorizationMode;

    @Value("${boa.authorizationUserName}")
    private String authorizationUserName;

    @Value("${boa.refreshTokenGrantType}")
    private String refreshTokenGrantType;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public AccountAccessConsentResponsePayload createConsent(AccountAccessConsentPayload payload, String token) {

        HttpHeaders headers = new HttpHeaders();
        headers.add(AUTHORIZATION, token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        System.out.println("Token in Create Consent: " + token);

        HttpEntity<AccountAccessConsentPayload> requestEntity = new HttpEntity<>(payload, headers);

        ResponseEntity<AccountAccessConsentResponsePayload> response = restTemplate
                .exchange(boaConsentUrl, HttpMethod.POST, requestEntity, AccountAccessConsentResponsePayload.class);
        return response.getBody();
    }

    @Override
    public TokenResponse fetchToken() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        final var tokenBody = new HttpHeaders();
        tokenBody.put(CLIENT_ID, List.of(clientId));
        tokenBody.put(CLIENT_SECRET, List.of(clientSecret));
        tokenBody.put(GRANT_TYPE, List.of(grantType));
        tokenBody.put(SCOPE, List.of(scope));

        HttpEntity<HttpHeaders> requestEntity = new HttpEntity<>(tokenBody, headers);

        ResponseEntity<TokenResponse> response = restTemplate.exchange(boaTokenUrl, HttpMethod.POST,
                requestEntity, TokenResponse.class);
        return response.getBody();
    }

    @Override
    public AuthorizeConsentResponse authorize(AuthorizeConsentPayload payload) {

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(authorizeUrl)
                .queryParam(REDIRECT_URI, redirectUrl)
                .queryParam(STATE, state)
                .queryParam(REQUEST, payload.getConsentId())
                .queryParam(AUTHORIZATION_MODE, authorizationMode)
                .queryParam(AUTHORIZATION_USERNAME, authorizationUserName);

        String uriString = uriComponentsBuilder.toUriString()
                + AMPERSAND + CLIENT_ID + EQUALS + clientId
                + AMPERSAND + RESPONSE_TYPE + EQUALS + responseType
                + AMPERSAND + SCOPE + EQUALS + authorizeScope;

        HttpEntity<Object> requestEntity = new HttpEntity<>(new HttpHeaders());

        ResponseEntity<AuthorizeConsentResponse> response = restTemplate.exchange(uriString,
                HttpMethod.GET, requestEntity, AuthorizeConsentResponse.class);

        return response.getBody();
    }

    @Override
    public RefreshTokenResponse fetchRefreshToken(String code) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        final var tokenBody = new HttpHeaders();
        tokenBody.put(CLIENT_ID, List.of(clientId));
        tokenBody.put(CLIENT_SECRET, List.of(clientSecret));
        tokenBody.put(REDIRECT_URI,List.of(redirectUrl));
        tokenBody.put(GRANT_TYPE, List.of("authorization_code"));
        tokenBody.put(CODE, List.of(code));

        HttpEntity<HttpHeaders> requestEntity = new HttpEntity<>(tokenBody, headers);

        ResponseEntity<RefreshTokenResponse> response = restTemplate.exchange(boaTokenUrl, HttpMethod.POST,
                requestEntity, RefreshTokenResponse.class);

        return response.getBody();
    }

}
