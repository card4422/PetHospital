package com.hospital.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by zhuzheng on 17/3/21.
 */
@Entity
public class Case {
    private int id;
    private String caseName;
    private Integer symptom;
    private Integer exam;
    private Integer result;
    private Integer method;

    @Id
    @Autowired
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "case_name", nullable = true, length = 255)
    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    @Basic
    @Column(name = "symptom", nullable = true)
    public Integer getSymptom() {
        return symptom;
    }

    public void setSymptom(Integer symptom) {
        this.symptom = symptom;
    }

    @Basic
    @Column(name = "exam", nullable = true)
    public Integer getExam() {
        return exam;
    }

    public void setExam(Integer exam) {
        this.exam = exam;
    }

    @Basic
    @Column(name = "result", nullable = true)
    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @Basic
    @Column(name = "method", nullable = true)
    public Integer getMethod() {
        return method;
    }

    public void setMethod(Integer method) {
        this.method = method;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Case aCase = (Case) o;

        if (id != aCase.id) return false;
        if (caseName != null ? !caseName.equals(aCase.caseName) : aCase.caseName != null) return false;
        if (symptom != null ? !symptom.equals(aCase.symptom) : aCase.symptom != null) return false;
        if (exam != null ? !exam.equals(aCase.exam) : aCase.exam != null) return false;
        if (result != null ? !result.equals(aCase.result) : aCase.result != null) return false;
        if (method != null ? !method.equals(aCase.method) : aCase.method != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = id;
        result1 = 31 * result1 + (caseName != null ? caseName.hashCode() : 0);
        result1 = 31 * result1 + (symptom != null ? symptom.hashCode() : 0);
        result1 = 31 * result1 + (exam != null ? exam.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (method != null ? method.hashCode() : 0);
        return result1;
    }
}
