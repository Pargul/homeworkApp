package com.homework;

import java.time.LocalDateTime;

class LoanAnnex {

    private LocalDateTime createDate;
    private Integer additionalTerm;

    private LoanAnnex() {
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public Integer getAdditionalTerm() {
        return additionalTerm;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private LoanAnnex loanAnnex = new LoanAnnex();

        public Builder setCreateDate(LocalDateTime createDate) {
            loanAnnex.createDate = createDate;
            return this;
        }

        public Builder setAdditionalTerm(Integer additionalTerm) {
            loanAnnex.additionalTerm = additionalTerm;
            return this;
        }

        public LoanAnnex build() {
            return loanAnnex;
        }

    }
}
