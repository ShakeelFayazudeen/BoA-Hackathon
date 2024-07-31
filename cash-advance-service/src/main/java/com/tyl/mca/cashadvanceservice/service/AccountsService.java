package com.tyl.mca.cashadvanceservice.service;

import com.tyl.mca.cashadvanceservice.model.accounts.response.AccountsResponse;

import java.net.URISyntaxException;

public interface AccountsService {

    AccountsResponse getAccounts(String token) ;

    AccountsResponse getAccountsChain() throws URISyntaxException;

}
