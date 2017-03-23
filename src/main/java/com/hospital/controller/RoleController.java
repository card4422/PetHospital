package com.hospital.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.hospital.entity.Role;
import com.hospital.entity.User;
import com.hospital.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.Array;
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

    @RequestMapping(value = "admin/role/{page}", method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getRole(@PathVariable String page) {
        int pages = Integer.parseInt(page);
        List roles = roleService.getAllRole();
        List<Role> subroles = null;
        int total = (roles.size()-1)/10+1;
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
            List<Integer> roomAccess;
        }
        List<templateInfo> result = new ArrayList<templateInfo>();
        for (Role role : subroles) {
            templateInfo tempInfo = new templateInfo();//必须放在循环内
            tempInfo.id = role.getId();

            ObjectMapper objectMapper = new ObjectMapper();
            CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Integer.class);
            try {
                tempInfo.roomAccess = objectMapper.readValue(role.getRoomAccess(), listType);
            } catch (IOException e) {
                e.printStackTrace();
            }
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
        return "{\"data\":" + json + ",\"pages\":" + total + "}";
    }

    @RequestMapping(value = "admin/role",method = RequestMethod.PUT,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String updateRole(@RequestBody Role role){
        roleService.updateRole(role);
        return "{\"result\":true}";
    }


    @RequestMapping(value = "admin/role", method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String saveRole(@RequestBody Role role) {
        roleService.saveRole(role);
        return "{\"result\":true}";
    }

    @RequestMapping(value = "admin/role",method = RequestMethod.DELETE,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String deleteRole(@RequestBody Role role) {
        Integer id = role.getId();
        roleService.deleteRole(id);
        return "{\"result\":true}";
    }
}
