package com.hospital.dao;

import com.hospital.entity.CaseEntity;

import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
public interface CaseDao extends DomainDao<CaseEntity, Integer> {
    List<CaseEntity> getByName(String name);

    List<CaseEntity> getByClassification(String classification);

    CaseEntity getByID(Integer id);
}