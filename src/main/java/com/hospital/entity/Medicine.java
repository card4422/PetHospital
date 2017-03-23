package com.hospital.entity;

import javax.persistence.*;

/**
 * Created by Jimmy on 2017/3/23.
 */
@Entity
public class Medicine {
    private int id;
    private String medicineName;
    private Float medicinePrice;
    private Integer medicineType;
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
    @Column(name = "medicine_name", nullable = true, insertable = true, updatable = true, length = 255)
    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    @Basic
    @Column(name = "medicine_price", nullable = true, insertable = true, updatable = true, precision = 0)
    public Float getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(Float medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    @Basic
    @Column(name = "medicine_type", nullable = true, insertable = true, updatable = true)
    public Integer getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(Integer medicineType) {
        this.medicineType = medicineType;
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

        Medicine medicine = (Medicine) o;

        if (id != medicine.id) return false;
        if (medicineName != null ? !medicineName.equals(medicine.medicineName) : medicine.medicineName != null)
            return false;
        if (medicinePrice != null ? !medicinePrice.equals(medicine.medicinePrice) : medicine.medicinePrice != null)
            return false;
        if (medicineType != null ? !medicineType.equals(medicine.medicineType) : medicine.medicineType != null)
            return false;
        if (description != null ? !description.equals(medicine.description) : medicine.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (medicineName != null ? medicineName.hashCode() : 0);
        result = 31 * result + (medicinePrice != null ? medicinePrice.hashCode() : 0);
        result = 31 * result + (medicineType != null ? medicineType.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
