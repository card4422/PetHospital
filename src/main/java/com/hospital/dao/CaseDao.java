package com.hospital.dao;

import com.hospital.entity.Case;

/**
 * Created by Jimmy on 2017/3/11.
 */
public interface CaseDao extends DomainDao<Case, Integer> {
    Case getByName(String name);
}