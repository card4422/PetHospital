package com.hospital.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.entity.Staff;
import com.hospital.service.StaffService;
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
public class StaffController {

    @Autowired
    private StaffService staffService;

    @RequestMapping(value = "admin/staff/{page}", method = RequestMethod.GET)
    @ResponseBody
    public String getStaff(@PathVariable String page) {
        int pages = Integer.parseInt(page);
        List staffs = staffService.getAllStaff();
        List<Staff> substaffs = null;
        int fromIndex = (pages - 1) * 10;
        int total = (staffs.size() - 1) / 10 + 1;
        if (staffs.size() >= fromIndex) {
            int toIndex = pages * 10;
            if (staffs.size() >= toIndex) {
                substaffs = staffs.subList(fromIndex, toIndex);
            } else {
                substaffs = staffs.subList(fromIndex, staffs.size());
            }
        }
        class templateInfo {
            Integer id;
            String staffName;
            String title;
            Integer roomId;
        }
        List<templateInfo> result = new ArrayList<templateInfo>();
        for (Staff staff : substaffs) {
            templateInfo tempInfo = new templateInfo();//必须放在循环内
            tempInfo.id = staff.getId();
            tempInfo.staffName = staff.getStaffName();
            tempInfo.title = staff.getTitle();
            tempInfo.roomId = staff.getRoomId();
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

    @RequestMapping(value = "admin/staff",method = RequestMethod.PUT)
    @ResponseBody
    public String updateStaff(@RequestBody Staff staff){
        staffService.updateStaff(staff);
        return " Update success";
    }


    @RequestMapping(value = "admin/staff", method = RequestMethod.POST)
    @ResponseBody
    public String saveStaff(@RequestBody Staff staff) {
        staffService.saveStaff(staff);
        return "success!";
    }

    @RequestMapping(value = "admin/staff",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteStaff(@RequestBody Staff staff) {
        Integer id = staff.getId();
        staffService.deleteStaff(id);
        return "{\"result\":true}";
    }
}
