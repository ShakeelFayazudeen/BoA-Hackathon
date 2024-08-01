package com.tyl.mca.cashadvanceservice.controller;

import com.tyl.mca.cashadvanceservice.model.accounts.response.AccountsResponse;
import com.tyl.mca.cashadvanceservice.service.AccountsService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
public class AccountsController {

    private static final Logger log = LogManager.getLogger(ConsentController.class);

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private AccountsService accountsService;

    @GetMapping("/accounts")
    public ResponseEntity<AccountsResponse> getAccounts(@RequestHeader(value = "Authorization") String authorization) {
        String token = httpServletRequest.getHeader("Authorization");
        return new ResponseEntity<>(accountsService.getAccounts(token), HttpStatus.OK);
    }

    @GetMapping("/accounts-chain")
    public ResponseEntity<AccountsResponse> getAccountsChain() throws URISyntaxException {
        return new ResponseEntity<>(accountsService.getAccountsChain(), HttpStatus.OK);
    }
}
