package com.tyl.mca.cashadvanceservice.service;

import com.tyl.mca.cashadvanceservice.model.transaction.response.AccountTransactionsResponse;

public interface TransactionService {

    AccountTransactionsResponse getTransaction(String accountId, String token);
}
