package com.hospital.service;

import com.hospital.entity.Medicine;

import java.util.List;

/**
 * Created by zhuzheng on 17/3/16.
 */
public interface MedicineService {
    Integer saveMedicine(Medicine user);

    List<Medicine> getAllMedicine();

    Medicine getMedicine(String name);

    void deleteMedicine(Integer id);

    void updateMedicine(Medicine user);
}
