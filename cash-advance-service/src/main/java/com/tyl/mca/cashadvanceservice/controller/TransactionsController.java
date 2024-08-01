package com.tyl.mca.cashadvanceservice.controller;

import com.tyl.mca.cashadvanceservice.model.transaction.response.AccountTransactionsResponse;
import com.tyl.mca.cashadvanceservice.service.TransactionService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionsController {

    private static final Logger log = LogManager.getLogger(TransactionsController.class);

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/accounts/{accountId}/transactions")
    public ResponseEntity<AccountTransactionsResponse> getTransaction(
            @PathVariable("accountId") String accountId, @RequestHeader(value = "Authorization") String authorization) {
        String token = httpServletRequest.getHeader("Authorization");
        return new ResponseEntity<>(transactionService.getTransaction(accountId, token), HttpStatus.OK);
    }
}
