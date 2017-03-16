package com.hospital.service.impl;

import com.hospital.entity.Role;
import com.hospital.dao.RoleDao;
import com.hospital.service.RoleService;
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

    public Integer saveRole(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> getAllRole() {
        List list = roleRepository.findAll();
        return list;
    }

//    public Role getRole(String name){
//        return roleRepository.getByName(name);
//    }

    public void deleteRole(Integer id) {
        roleRepository.delete(id);
    }

    public void updateRole(Role role) {
        roleRepository.update(role);
    }
}
