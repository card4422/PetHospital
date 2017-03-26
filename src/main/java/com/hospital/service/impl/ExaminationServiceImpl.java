package com.hospital.service.impl;

import com.hospital.entity.Examination;
import com.hospital.dao.ExaminationDao;
import com.hospital.service.ExaminationService;
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
public class ExaminationServiceImpl implements ExaminationService {

    @Autowired
    private ExaminationDao examinationRepository;

    //log工厂
    private final Log log = LogFactory.getLog(getClass());

    public Integer saveExamination(Examination examination) {
        try {
            return examinationRepository.save(examination);
        } catch (HibernateException e) {
            log.error("在saveExamination出错了");
            log.error(e);
            e.printStackTrace();
        }
        return -1;
    }

    public List<Examination> getAllExamination() {
        try {
            List list = examinationRepository.findAll();
            return list;
        } catch (HibernateException e) {
            log.error("在getAllExamination出错了");
            log.error(e);
            e.printStackTrace();
        }
        return null;
    }

    public Examination getExamination(String name) {
        try {
            return examinationRepository.getByName(name);
        } catch (HibernateException e) {
            log.error("在getExamination出错了");
            log.error(e);
            e.printStackTrace();
        }
        return null;
    }

    public void deleteExamination(Integer id) {
        try {
            examinationRepository.delete(id);
        } catch (HibernateException e) {
            log.error("在deleteExamination出错了");
            log.error(e);
            e.printStackTrace();
        }
    }

    public void updateExamination(Examination examination) {
        try {
            examinationRepository.update(examination);
        } catch (HibernateException e) {
            log.error("在updateExamination出错了");
            log.error(e);
            e.printStackTrace();
        }
    }
}
