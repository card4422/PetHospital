package com.hospital.service.impl;

import com.hospital.entity.HospitalRecord;
import com.hospital.dao.HospitalRecordDao;
import com.hospital.service.HospitalRecordService;
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
public class HospitalRecordServiceImpl implements HospitalRecordService {

    @Autowired
    private HospitalRecordDao hospitalRecordRepository;

    //log工厂
    private final Log log = LogFactory.getLog(getClass());

    public Integer saveHospitalRecord(HospitalRecord hospitalRecord) {
        try {
            return hospitalRecordRepository.save(hospitalRecord);
        } catch (HibernateException e) {
            log.error("在saveHospitalRecord出错了");
            log.error(e);
            e.printStackTrace();
        }
        return -1;
    }

    public List<HospitalRecord> getAllHospitalRecord() {
        try {
            List list = hospitalRecordRepository.findAll();
            return list;
        } catch (HibernateException e) {
            log.error("在getAllHospitalRecord出错了");
            log.error(e);
            e.printStackTrace();
        }
        return null;
    }

//    public HospitalRecord getHospitalRecord(String name){
//        return hospitalRecordRepository.getByName(name);
//    }

    public void deleteHospitalRecord(Integer id) {
        try {
            hospitalRecordRepository.delete(id);
        } catch (HibernateException e) {
            log.error("在deleteHospitalRecord出错了");
            log.error(e);
            e.printStackTrace();
        }
    }

    public void updateHospitalRecord(HospitalRecord hospitalRecord) {
        try {
            hospitalRecordRepository.update(hospitalRecord);
        } catch (HibernateException e) {
            log.error("在updateHospitalRecord出错了");
            log.error(e);
            e.printStackTrace();
        }
    }
}
