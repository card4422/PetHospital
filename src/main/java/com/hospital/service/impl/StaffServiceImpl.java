package com.hospital.service.impl;

import com.hospital.entity.Staff;
import com.hospital.dao.StaffDao;
import com.hospital.service.StaffService;
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
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDao staffRepository;

    //log工厂
    private final Log log = LogFactory.getLog(getClass());

    public Integer saveStaff(Staff staff) {
        try {
            return staffRepository.save(staff);
        } catch (HibernateException e) {
            log.error("在saveStaff出错了");
            log.error(e);
            e.printStackTrace();
        }
        return -1;
    }

    public List<Staff> getAllStaff() {
        try {
            List list = staffRepository.findAll();
            return list;
        } catch (HibernateException e) {
            log.error("在getAllStaff出错了");
            log.error(e);
            e.printStackTrace();
        }
        return null;
    }

    public Staff getStaff(String name) {
        try {
            return staffRepository.getByName(name);
        } catch (HibernateException e) {
            log.error("在getStaff出错了");
            log.error(e);
            e.printStackTrace();
        }
        return null;
    }

    public void deleteStaff(Integer id) {
        try {
            staffRepository.delete(id);
        } catch (HibernateException e) {
            log.error("在deleteStaff出错了");
            log.error(e);
            e.printStackTrace();
        }
    }

    public void updateStaff(Staff staff) {
        try {
            staffRepository.update(staff);
        } catch (HibernateException e) {
            log.error("在updateStaff出错了");
            log.error(e);
            e.printStackTrace();
        }
    }
}
