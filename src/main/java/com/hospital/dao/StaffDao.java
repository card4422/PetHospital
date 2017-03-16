package com.hospital.dao;

import com.hospital.entity.Staff;

/**
 * Created by Jimmy on 2017/3/11.
 */
public interface StaffDao extends DomainDao<Staff, Integer> {
    Staff getByName(String name);
}