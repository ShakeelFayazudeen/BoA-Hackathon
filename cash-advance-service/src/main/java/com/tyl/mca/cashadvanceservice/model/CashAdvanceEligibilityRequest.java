package com.tyl.mca.cashadvanceservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CashAdvanceEligibilityRequest {

    public BigDecimal monthlyTransaction;
    public BigDecimal eligibilityMultiplier;
}
