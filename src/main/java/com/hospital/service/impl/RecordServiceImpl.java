package com.hospital.service.impl;

import com.hospital.entity.Record;
import com.hospital.dao.RecordDao;
import com.hospital.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordDao recordRepository;

    public Integer saveRecord(Record record) {
        return recordRepository.save(record);
    }

    public List<Record> getAllRecord() {
        List list = recordRepository.findAll();
        return list;
    }

//    public Record getRecord(String name){
//        return recordRepository.getByName(name);
//    }

    public void deleteRecord(Integer id) {
        recordRepository.delete(id);
    }

    public void updateRecord(Record record) {
        recordRepository.update(record);
    }
}
