package com.tyl.mca.cashadvanceservice.controller;

import com.tyl.mca.cashadvanceservice.model.RefreshTokenResponse;
import com.tyl.mca.cashadvanceservice.model.TokenResponse;
import com.tyl.mca.cashadvanceservice.model.consent.request.AccountAccessConsentPayload;
import com.tyl.mca.cashadvanceservice.model.consent.response.AccountAccessConsentResponsePayload;
import com.tyl.mca.cashadvanceservice.model.consent.response.AuthorizeConsentPayload;
import com.tyl.mca.cashadvanceservice.model.consent.response.AuthorizeConsentResponse;
import com.tyl.mca.cashadvanceservice.service.ConsentService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
public class ConsentController {

    private static final Logger log = LogManager.getLogger(ConsentController.class);

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private ConsentService consentService;

    @GetMapping("/token")
    public ResponseEntity<TokenResponse> fetchToken() {
        return new ResponseEntity<>(consentService.fetchToken(), HttpStatus.OK);
    }

    @PostMapping("/account-access-consents")
    public ResponseEntity<AccountAccessConsentResponsePayload> createConsent
            (@RequestBody AccountAccessConsentPayload payload,
             @RequestHeader(value = "Authorization") String authorization) {
        log.info(payload.toString());
        String token = httpServletRequest.getHeader("Authorization");
        return new ResponseEntity<>(consentService.createConsent(payload, token), HttpStatus.CREATED);
    }

    @PostMapping("/authorize")
    public ResponseEntity<AuthorizeConsentResponse> authorize(@RequestBody AuthorizeConsentPayload payload) throws URISyntaxException {
        return new ResponseEntity<>(consentService.authorize(payload), HttpStatus.OK);
    }

    @GetMapping("/refresh-token")
    public ResponseEntity<RefreshTokenResponse> fetchRefreshToken(@RequestHeader(value = "Code") String code) {
        return new ResponseEntity<>(consentService.fetchRefreshToken(code), HttpStatus.OK);
    }

}
