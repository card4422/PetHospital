package com.hospital.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by zhuzheng on 17/3/16.
 */
@Entity
public class Diagnosis {
    private int diagnosisId;
    private String diagnosisDescription;
    private Double diagnosisPrice;

    @Id
    @Column(name = "diagnosis_id", nullable = false)
    public int getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(int diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    @Basic
    @Column(name = "diagnosis_description", nullable = true, length = 255)
    public String getDiagnosisDescription() {
        return diagnosisDescription;
    }

    public void setDiagnosisDescription(String diagnosisDescription) {
        this.diagnosisDescription = diagnosisDescription;
    }

    @Basic
    @Column(name = "diagnosis_price", nullable = true, precision = 0)
    public Double getDiagnosisPrice() {
        return diagnosisPrice;
    }

    public void setDiagnosisPrice(Double diagnosisPrice) {
        this.diagnosisPrice = diagnosisPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Diagnosis diagnosis = (Diagnosis) o;

        if (diagnosisId != diagnosis.diagnosisId) return false;
        if (diagnosisDescription != null ? !diagnosisDescription.equals(diagnosis.diagnosisDescription) : diagnosis.diagnosisDescription != null)
            return false;
        if (diagnosisPrice != null ? !diagnosisPrice.equals(diagnosis.diagnosisPrice) : diagnosis.diagnosisPrice != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = diagnosisId;
        result = 31 * result + (diagnosisDescription != null ? diagnosisDescription.hashCode() : 0);
        result = 31 * result + (diagnosisPrice != null ? diagnosisPrice.hashCode() : 0);
        return result;
    }
}
