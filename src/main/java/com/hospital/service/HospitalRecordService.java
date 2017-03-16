package com.hospital.service;

import com.hospital.entity.HospitalRecord;

import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
public interface HospitalRecordService {
    Integer saveHospitalRecord(HospitalRecord hospitalRecord);

    List<HospitalRecord> getAllHospitalRecord();

//    HospitalRecord getHospitalRecord(String name);

    void deleteHospitalRecord(Integer id);

    void updateHospitalRecord(HospitalRecord hospitalRecord);

}
