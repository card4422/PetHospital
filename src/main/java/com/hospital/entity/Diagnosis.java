package com.hospital.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Jimmy on 2017/3/16.
 */
@Entity
public class Diagnosis {
    private int id;
    private String diagnosisDescription;
    private Float diagnosisPrice;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "diagnosis_description", nullable = true, insertable = true, updatable = true, length = 255)
    public String getDiagnosisDescription() {
        return diagnosisDescription;
    }

    public void setDiagnosisDescription(String diagnosisDescription) {
        this.diagnosisDescription = diagnosisDescription;
    }

    @Basic
    @Column(name = "diagnosis_price", nullable = true, insertable = true, updatable = true, precision = 0)
    public Float getDiagnosisPrice() {
        return diagnosisPrice;
    }

    public void setDiagnosisPrice(Float diagnosisPrice) {
        this.diagnosisPrice = diagnosisPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Diagnosis diagnosis = (Diagnosis) o;

        if (id != diagnosis.id) return false;
        if (diagnosisDescription != null ? !diagnosisDescription.equals(diagnosis.diagnosisDescription) : diagnosis.diagnosisDescription != null)
            return false;
        if (diagnosisPrice != null ? !diagnosisPrice.equals(diagnosis.diagnosisPrice) : diagnosis.diagnosisPrice != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (diagnosisDescription != null ? diagnosisDescription.hashCode() : 0);
        result = 31 * result + (diagnosisPrice != null ? diagnosisPrice.hashCode() : 0);
        return result;
    }
}
