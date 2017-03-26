package com.hospital.service.impl;

import com.hospital.entity.Record;
import com.hospital.dao.RecordDao;
import com.hospital.service.RecordService;
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
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordDao recordRepository;

    //log工厂
    private final Log log = LogFactory.getLog(getClass());

    public Integer saveRecord(Record record) {
        try {
            return recordRepository.save(record);
        } catch (HibernateException e) {
            log.error("在saveRecord出错了");
            log.error(e);
            e.printStackTrace();
        }
        return -1;
    }

    public List<Record> getAllRecord() {
        try {
            List list = recordRepository.findAll();
            return list;
        } catch (HibernateException e) {
            log.error("在getAllRecord出错了");
            log.error(e);
            e.printStackTrace();
        }
        return null;
    }

//    public Record getRecord(String name){
//        return recordRepository.getByName(name);
//    }

    public void deleteRecord(Integer id) {
        try {
            recordRepository.delete(id);
        } catch (HibernateException e) {
            log.error("在deleteRecord出错了");
            log.error(e);
            e.printStackTrace();
        }
    }

    public void updateRecord(Record record) {
        try {
            recordRepository.update(record);
        } catch (HibernateException e) {
            log.error("在updateRecord出错了");
            log.error(e);
            e.printStackTrace();
        }
    }
}
