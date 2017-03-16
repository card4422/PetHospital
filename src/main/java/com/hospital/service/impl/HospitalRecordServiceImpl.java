package com.hospital.service.impl;

import com.hospital.entity.HospitalRecord;
import com.hospital.dao.HospitalRecordDao;
import com.hospital.service.HospitalRecordService;
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

    public Integer saveHospitalRecord(HospitalRecord hospitalRecord) {
        return hospitalRecordRepository.save(hospitalRecord);
    }

    public List<HospitalRecord> getAllHospitalRecord() {
        List list = hospitalRecordRepository.findAll();
        return list;
    }

//    public HospitalRecord getHospitalRecord(String name){
//        return hospitalRecordRepository.getByName(name);
//    }

    public void deleteHospitalRecord(Integer id) {
        hospitalRecordRepository.delete(id);
    }

    public void updateHospitalRecord(HospitalRecord hospitalRecord) {
        hospitalRecordRepository.update(hospitalRecord);
    }
}
