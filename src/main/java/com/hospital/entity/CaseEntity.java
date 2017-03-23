package com.hospital.entity;

import javax.persistence.*;

/**
 * Created by Jimmy on 2017/3/23.
 */
@Entity
@Table(name = "case_entity", schema = "", catalog = "pethospital")
public class CaseEntity {
    private int id;
    private String caseName;
    private Integer symptom;
    private Integer exam;
    private Integer result;
    private Integer method;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "case_name", nullable = true, insertable = true, updatable = true, length = 255)
    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    @Basic
    @Column(name = "symptom", nullable = true, insertable = true, updatable = true)
    public Integer getSymptom() {
        return symptom;
    }

    public void setSymptom(Integer symptom) {
        this.symptom = symptom;
    }

    @Basic
    @Column(name = "exam", nullable = true, insertable = true, updatable = true)
    public Integer getExam() {
        return exam;
    }

    public void setExam(Integer exam) {
        this.exam = exam;
    }

    @Basic
    @Column(name = "result", nullable = true, insertable = true, updatable = true)
    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @Basic
    @Column(name = "method", nullable = true, insertable = true, updatable = true)
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

        CaseEntity that = (CaseEntity) o;

        if (id != that.id) return false;
        if (caseName != null ? !caseName.equals(that.caseName) : that.caseName != null) return false;
        if (symptom != null ? !symptom.equals(that.symptom) : that.symptom != null) return false;
        if (exam != null ? !exam.equals(that.exam) : that.exam != null) return false;
        if (result != null ? !result.equals(that.result) : that.result != null) return false;
        if (method != null ? !method.equals(that.method) : that.method != null) return false;

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
