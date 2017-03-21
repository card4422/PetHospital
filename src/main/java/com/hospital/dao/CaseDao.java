package com.hospital.dao;

import com.hospital.entity.CaseEntity;

/**
 * Created by Jimmy on 2017/3/11.
 */
public interface CaseDao extends DomainDao<CaseEntity, Integer> {
    CaseEntity getByName(String name);
}