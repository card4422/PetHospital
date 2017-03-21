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
public class Examination {
    private int id;
    private String examinationName;
    private Double examinationPrice;
    private String description;

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
    @Column(name = "examination _name", nullable = true, length = 255)
    public String getExaminationName() {
        return examinationName;
    }

    public void setExaminationName(String examinationName) {
        this.examinationName = examinationName;
    }

    @Basic
    @Column(name = "examination _price", nullable = true, precision = 0)
    public Double getExaminationPrice() {
        return examinationPrice;
    }

    public void setExaminationPrice(Double examinationPrice) {
        this.examinationPrice = examinationPrice;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 255)
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
