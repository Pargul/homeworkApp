package com.homework;

import com.homework.conf.LoanConfigurationProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoanControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void loanHappyPath() {

        final Integer TERM = 10;
        final BigDecimal AMOUNT = BigDecimal.valueOf(110);
        String applyForLoanUrl = String.format(createURLWithPort("/apply_for_loan?term=%s&amount=%s"), TERM, AMOUNT);

        ApplyForLoanResponse applyForLoanResponse =
                testRestTemplate.getForObject(applyForLoanUrl, ApplyForLoanResponse.class);

        Assert.assertEquals(AMOUNT, applyForLoanResponse.getAmount());
        Assert.assertEquals(LocalDate.now().plusDays(TERM), applyForLoanResponse.getLoanEnd());

        String extendLoanUrl = String.format(createURLWithPort("/extend_loan?loanId=%s"), applyForLoanResponse.getLoanId());

        ExtendLoanResponse extendLoanResponse =
                testRestTemplate.getForObject(extendLoanUrl, ExtendLoanResponse.class);
        Assert.assertEquals(applyForLoanResponse.getLoanEnd().plusDays(LoanConfigurationProperties.ADDITIONAL_TERM), extendLoanResponse.getLoanEndDate());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
