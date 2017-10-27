package com.company.samplechecklist.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.List;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@NamePattern("%s|number")
@Table(name = "SAMPLECHECKLIST_LOAN_APPLICATION")
@Entity(name = "samplechecklist$LoanApplication")
public class LoanApplication extends StandardEntity {
    private static final long serialVersionUID = 8792556739925912802L;

    @NotNull
    @Column(name = "NUMBER_", nullable = false)
    protected String number;

    @Column(name = "APPLICANT_NAME", nullable = false)
    protected String applicantName;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "loanApplication")
    protected List<CheckItem> checks;

    public void setChecks(List<CheckItem> checks) {
        this.checks = checks;
    }

    public List<CheckItem> getChecks() {
        return checks;
    }


    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }


    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantName() {
        return applicantName;
    }


}