package com.hospital.service;

import com.hospital.entity.Record;

import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
public interface RecordService {
    Integer saveRecord(Record record);

    List<Record> getAllRecord();

//    Record getRecord(String name);

    void deleteRecord(Integer id);

    void updateRecord(Record record);

}
