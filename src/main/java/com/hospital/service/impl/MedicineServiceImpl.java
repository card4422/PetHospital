package com.hospital.service.impl;

import com.hospital.entity.Medicine;
import com.hospital.dao.MedicineDao;
import com.hospital.service.MedicineService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
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

    //log工厂
    private final Log log = LogFactory.getLog(getClass());

    public Integer saveMedicine(Medicine medicine) {
        try {
            return medicineRepository.save(medicine);
        } catch (HibernateException e) {
            log.error("在saveMedicine出错了");
            log.error(e);
            e.printStackTrace();
        }
        return -1;
    }

    public List<Medicine> getAllMedicine() {
        try {
            List list = medicineRepository.findAll();
            return list;
        } catch (HibernateException e) {
            log.error("在getAllMedicine出错了");
            log.error(e);
            e.printStackTrace();
        }
        return null;
    }

    public Medicine getMedicine(String name) {
        try {
            return medicineRepository.getByName(name);
        } catch (HibernateException e) {
            log.error("在getMedicine出错了");
            log.error(e);
            e.printStackTrace();
        }
        return null;
    }

    public void deleteMedicine(Integer id) {
        try {
            medicineRepository.delete(id);
        } catch (HibernateException e) {
            log.error("在deleteMedicine出错了");
            log.error(e);
            e.printStackTrace();
        }
    }

    public void updateMedicine(Medicine medicine) {
        try {
            medicineRepository.update(medicine);
        } catch (HibernateException e) {
            log.error("在updateMedicine出错了");
            log.error(e);
            e.printStackTrace();
        }
    }
}