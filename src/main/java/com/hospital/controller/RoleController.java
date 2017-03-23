package com.hospital.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.entity.Role;
import com.hospital.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jimmy on 2017/3/17.
 */
@Controller
@RequestMapping("/")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "admin/role/{page}", method = RequestMethod.GET)
    @ResponseBody
    public String getRole(@PathVariable String page) {
        int pages = Integer.parseInt(page);
        List roles = roleService.getAllRole();
        List<Role> subroles = null;
        int fromIndex = (pages - 1) * 10;
        if (roles.size() >= fromIndex) {
            int toIndex = pages * 10;
            if (roles.size() >= toIndex) {
                subroles = roles.subList(fromIndex, toIndex);
            } else {
                subroles = roles.subList(fromIndex, roles.size());
            }
        }
        class templateInfo {
            Integer id;
            String roomAccess;
        }
        List<templateInfo> result = new ArrayList<templateInfo>();
        for (Role role : subroles) {
            templateInfo tempInfo = new templateInfo();//必须放在循环内
            tempInfo.id = role.getId();
            tempInfo.roomAccess = role.getRoomAccess();
            result.add(tempInfo);
        }
        String json = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        try {
            json = objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "{\"data\":" + json + ",\"pages\":" + page + "}";
    }

    @RequestMapping(value = "admin/role",method = RequestMethod.PUT)
    @ResponseBody
    public String updateRole(@RequestBody Role role){
        roleService.updateRole(role);
        return " Update success";
    }


    @RequestMapping(value = "admin/role", method = RequestMethod.POST)
    @ResponseBody
    public String saveRole(@RequestBody Role role) {
        roleService.saveRole(role);
        return "success!";
    }

    @RequestMapping(value = "admin/role",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteRole(@RequestBody Role role) {
        Integer id = role.getId();
        roleService.deleteRole(id);
        return "{result:true}";
    }
}
