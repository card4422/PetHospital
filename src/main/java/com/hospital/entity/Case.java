package com.hospital.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by zhuzheng on 17/3/16.
 */
@Entity
public class Case {
    private int caseId;
    private String caseName;

    @Id
    @Column(name = "case_id", nullable = false)
    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    @Basic
    @Column(name = "case_name", nullable = true, length = 255)
    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Case aCase = (Case) o;

        if (caseId != aCase.caseId) return false;
        if (caseName != null ? !caseName.equals(aCase.caseName) : aCase.caseName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = caseId;
        result = 31 * result + (caseName != null ? caseName.hashCode() : 0);
        return result;
    }
}
