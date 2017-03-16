package com.hospital.service;

import com.hospital.entity.Role;

import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
public interface RoleService {
    Integer saveRole(Role role);

    List<Role> getAllRole();

//    Role getRole(String name);

    void deleteRole(Integer id);

    void updateRole(Role role);

}
