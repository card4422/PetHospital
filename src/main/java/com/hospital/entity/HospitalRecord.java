package com.hospital.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhuzheng on 17/3/16.
 */
@Entity
@Table(name = "hospital_record", schema = "pethospital", catalog = "")
public class HospitalRecord {
    private int hrId;
    private String patient;
    private Date startTime;
    private Date endTime;
    private String description;

    @Id
    @Column(name = "hr_id", nullable = false)
    public int getHrId() {
        return hrId;
    }

    public void setHrId(int hrId) {
        this.hrId = hrId;
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
    @Column(name = "start_time", nullable = true)
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time", nullable = true)
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

        HospitalRecord that = (HospitalRecord) o;

        if (hrId != that.hrId) return false;
        if (patient != null ? !patient.equals(that.patient) : that.patient != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hrId;
        result = 31 * result + (patient != null ? patient.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
