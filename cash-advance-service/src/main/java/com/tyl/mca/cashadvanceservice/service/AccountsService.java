package com.tyl.mca.cashadvanceservice.service;

import com.tyl.mca.cashadvanceservice.model.accounts.response.AccountsResponse;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;

public interface AccountsService {

    AccountsResponse getAccounts(String token) ;

    ResponseEntity<AccountsResponse> getAccountsChain() throws URISyntaxException;

}
