package com.hospital.entity;

import javax.persistence.*;

/**
 * Created by Jimmy on 2017/3/23.
 */
@Entity
public class Examination {
    private int id;
    private String examinationName;
    private Float examinationPrice;
    private String description;

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
    @Column(name = "examination_name", nullable = true, insertable = true, updatable = true, length = 255)
    public String getExaminationName() {
        return examinationName;
    }

    public void setExaminationName(String examinationName) {
        this.examinationName = examinationName;
    }

    @Basic
    @Column(name = "examination_price", nullable = true, insertable = true, updatable = true, precision = 0)
    public Float getExaminationPrice() {
        return examinationPrice;
    }

    public void setExaminationPrice(Float examinationPrice) {
        this.examinationPrice = examinationPrice;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Examination that = (Examination) o;

        if (id != that.id) return false;
        if (examinationName != null ? !examinationName.equals(that.examinationName) : that.examinationName != null)
            return false;
        if (examinationPrice != null ? !examinationPrice.equals(that.examinationPrice) : that.examinationPrice != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (examinationName != null ? examinationName.hashCode() : 0);
        result = 31 * result + (examinationPrice != null ? examinationPrice.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
