package com.tyl.mca.cashadvanceservice.controller;

import com.tyl.mca.cashadvanceservice.model.CashAdvanceEligibilityRequest;
import com.tyl.mca.cashadvanceservice.model.CashAdvanceRepayableRequest;
import com.tyl.mca.cashadvanceservice.model.Repayment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class CashAdvanceController {



    @PostMapping("/amount-repayable")
    public ResponseEntity<Repayment> getAmountRepayable(@RequestBody CashAdvanceRepayableRequest cashAdvanceRepayableRequest) {
        BigDecimal amountRepayable = cashAdvanceRepayableRequest.getCashAdvance().multiply(cashAdvanceRepayableRequest.getFactorRate());
        return new ResponseEntity<>(new Repayment(amountRepayable), HttpStatus.OK);
    }

    @PostMapping("/amount-eligible")
    public ResponseEntity<BigDecimal> getEligibleAmount(@RequestBody CashAdvanceEligibilityRequest cashAdvanceEligibilityRequest) {
        BigDecimal eligibleAmount = cashAdvanceEligibilityRequest.getMonthlyTransaction().multiply(cashAdvanceEligibilityRequest.getEligibilityMultiplier());
        return new ResponseEntity<>(eligibleAmount, HttpStatus.OK);
    }
}
