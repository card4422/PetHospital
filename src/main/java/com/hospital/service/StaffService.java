package com.hospital.service;

import com.hospital.entity.Staff;

import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
public interface StaffService {
    Integer saveStaff(Staff staff);

    List<Staff> getAllStaff();

    Staff getStaff(String name);

    void deleteStaff(Integer id);

    void updateStaff(Staff staff);

}
