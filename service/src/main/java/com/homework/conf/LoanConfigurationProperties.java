package com.homework.conf;

import java.math.BigDecimal;


public class LoanConfigurationProperties {

    public static final BigDecimal MIN_AMOUNT = BigDecimal.valueOf(100);
    public static final BigDecimal MAX_AMOUNT = BigDecimal.valueOf(10000);
    public static final Integer MIN_HOUR = 0;
    public static final Integer MAX_HOUR = 6;
    public static final Double LOAN_COST = 0.1;
    public static final Integer ADDITIONAL_TERM = 10;
}
