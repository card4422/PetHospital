package com.hospital.service.impl;

import com.hospital.entity.Medicine;
import com.hospital.dao.MedicineDao;
import com.hospital.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineDao medicineRepository;

    public Integer saveMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    public List<Medicine> getAllMedicine() {
        List list = medicineRepository.findAll();
        return list;
    }

    public Medicine getMedicine(String name) {
        return medicineRepository.getByName(name);
    }

    public void deleteMedicine(Integer id) {
        medicineRepository.delete(id);
    }

    public void updateMedicine(Medicine medicine) {
        medicineRepository.update(medicine);
    }
}