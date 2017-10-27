package com.company.samplechecklist.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.StandardEntity;

@Table(name = "SAMPLECHECKLIST_CHECK_ITEM")
@Entity(name = "samplechecklist$CheckItem")
public class CheckItem extends StandardEntity {
    private static final long serialVersionUID = -4548682278894065175L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CHECK_ID")
    protected Check check;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OPTION_ID")
    protected Option option;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LOAN_APPLICATION_ID")
    protected LoanApplication loanApplication;

    public void setLoanApplication(LoanApplication loanApplication) {
        this.loanApplication = loanApplication;
    }

    public LoanApplication getLoanApplication() {
        return loanApplication;
    }


    public void setCheck(Check check) {
        this.check = check;
    }

    public Check getCheck() {
        return check;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public Option getOption() {
        return option;
    }


}