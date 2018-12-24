package com.homework;

import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {LoanTermServiceImpl.class})
public class LoanTermServiceImplTest {

    @Autowired
    private LoanTermService tested;

    @Test
    public void test() {
        Loan loan = Loan.builder()
                .setTerm(10)
                .setAnnexList(Lists.newArrayList(LoanAnnex.builder().setAdditionalTerm(5).build()))
                .build();
        Assert.assertEquals(LocalDate.now().plusDays(15), tested.calculateLoanEndDate(loan));
    }
}
