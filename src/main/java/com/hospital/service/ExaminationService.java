package com.hospital.service;

import com.hospital.entity.Examination;

import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
public interface ExaminationService {
    Integer saveExamination(Examination examination);

    List<Examination> getAllExamination();

    Examination getExamination(String name);

    void deleteExamination(Integer id);

    void updateExamination(Examination examination);

}
