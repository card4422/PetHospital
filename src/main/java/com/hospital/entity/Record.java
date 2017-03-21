package com.hospital.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by zhuzheng on 17/3/21.
 */
@Entity
public class Record {
    private int id;
    private Date time;
    private String patient;
    private String petType;
    private String description;
    private Float price;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "time", nullable = true)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Basic
    @Column(name = "patient", nullable = true, length = 255)
    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    @Basic
    @Column(name = "pet_type", nullable = true, length = 255)
    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record record = (Record) o;

        if (id != record.id) return false;
        if (time != null ? !time.equals(record.time) : record.time != null) return false;
        if (patient != null ? !patient.equals(record.patient) : record.patient != null) return false;
        if (petType != null ? !petType.equals(record.petType) : record.petType != null) return false;
        if (description != null ? !description.equals(record.description) : record.description != null) return false;
        if (price != null ? !price.equals(record.price) : record.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (patient != null ? patient.hashCode() : 0);
        result = 31 * result + (petType != null ? petType.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
