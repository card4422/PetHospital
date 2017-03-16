package com.hospital.dao;

import com.hospital.entity.Examination;

/**
 * Created by Jimmy on 2017/3/11.
 */
public interface ExaminationDao extends DomainDao<Examination, Integer> {
    Examination getByName(String name);
}