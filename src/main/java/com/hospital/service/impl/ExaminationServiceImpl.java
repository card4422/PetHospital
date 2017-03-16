package com.hospital.service.impl;

import com.hospital.entity.Examination;
import com.hospital.dao.ExaminationDao;
import com.hospital.service.ExaminationService;
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

    public Integer saveExamination(Examination examination) {
        return examinationRepository.save(examination);
    }

    public List<Examination> getAllExamination() {
        List list = examinationRepository.findAll();
        return list;
    }

    public Examination getExamination(String name) {
        return examinationRepository.getByName(name);
    }

    public void deleteExamination(Integer id) {
        examinationRepository.delete(id);
    }

    public void updateExamination(Examination examination) {
        examinationRepository.update(examination);
    }
}
