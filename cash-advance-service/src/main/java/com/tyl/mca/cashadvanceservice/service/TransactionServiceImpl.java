package com.tyl.mca.cashadvanceservice.service;

import com.tyl.mca.cashadvanceservice.model.transaction.response.AccountTransactionsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Value("${boa.transactionUrl}")
    private String boaTransactionUrl;

    @Autowired
    private ConsentService consentService;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public AccountTransactionsResponse getTransaction(String accountId, String token) {

        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("accountId", accountId);

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(boaTransactionUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.add(AUTHORIZATION, token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);

        System.out.println(uriComponentsBuilder.buildAndExpand(urlParams).toUri());

        ResponseEntity<AccountTransactionsResponse> response = restTemplate
                .exchange(uriComponentsBuilder.buildAndExpand(urlParams).toUri(), HttpMethod.GET, requestEntity, AccountTransactionsResponse.class);
        return response.getBody();
    }
}
