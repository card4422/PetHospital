package com.hospital.service.impl;

import com.hospital.entity.Staff;
import com.hospital.dao.StaffDao;
import com.hospital.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDao staffRepository;

    public Integer saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public List<Staff> getAllStaff() {
        List list = staffRepository.findAll();
        return list;
    }

    public Staff getStaff(String name) {
        return staffRepository.getByName(name);
    }

    public void deleteStaff(Integer id) {
        staffRepository.delete(id);
    }

    public void updateStaff(Staff staff) {
        staffRepository.update(staff);
    }
}
