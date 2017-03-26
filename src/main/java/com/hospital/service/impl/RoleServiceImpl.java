package com.hospital.service.impl;

import com.hospital.entity.Role;
import com.hospital.dao.RoleDao;
import com.hospital.service.RoleService;
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
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleRepository;

    //log工厂
    private final Log log = LogFactory.getLog(getClass());

    public Integer saveRole(Role role) {
        try {
            return roleRepository.save(role);
        } catch (HibernateException e) {
            log.error("在saveRole出错了");
            log.error(e);
            e.printStackTrace();
        }
        return -1;
    }

    public List<Role> getAllRole() {
        try {
            List list = roleRepository.findAll();
            return list;
        } catch (HibernateException e) {
            log.error("在getAllRole出错了");
            log.error(e);
            e.printStackTrace();
        }
        return null;
    }

//    public Role getRole(String name){
//        return roleRepository.getByName(name);
//    }

    public void deleteRole(Integer id) {
        try {
            roleRepository.delete(id);
        } catch (HibernateException e) {
            log.error("在deleteRole出错了");
            log.error(e);
            e.printStackTrace();
        }
    }

    public void updateRole(Role role) {
        try {
            roleRepository.update(role);
        } catch (HibernateException e) {
            log.error("在updateRole出错了");
            log.error(e);
            e.printStackTrace();
        }
    }
}
