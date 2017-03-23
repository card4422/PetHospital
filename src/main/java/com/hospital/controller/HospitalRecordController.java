package com.hospital.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.entity.HospitalRecord;
import com.hospital.service.HospitalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jimmy on 2017/3/17.
 */

@Controller
@RequestMapping("/")
public class HospitalRecordController {

    @Autowired
    private HospitalRecordService hospitalRecordService;

    @RequestMapping(value = "admin/hospitalRecord/{page}", method = RequestMethod.GET)
    @ResponseBody
    public String getHospitalRecords(@PathVariable String page) {
        int pages = Integer.parseInt(page);
        List hospitalRecords = hospitalRecordService.getAllHospitalRecord();
        List<HospitalRecord> subhospitalRecords = null;
        int fromIndex = (pages - 1) * 10;
        if (hospitalRecords.size() >= fromIndex) {
            int toIndex = pages * 10;
            if (hospitalRecords.size() >= toIndex) {
                subhospitalRecords = hospitalRecords.subList(fromIndex, toIndex);
            } else {
                subhospitalRecords = hospitalRecords.subList(fromIndex, hospitalRecords.size());
            }
        }
        class templateInfo {
            Integer id;
            String patient;
            Date startTime;
            Date endTime;
            String description;
        }
        List<templateInfo> result = new ArrayList<templateInfo>();
        for (HospitalRecord hospitalRecord : subhospitalRecords) {
            templateInfo tempInfo = new templateInfo();//必须放在循环内
            tempInfo.id = hospitalRecord.getId();
            tempInfo.patient = hospitalRecord.getPatient();
            tempInfo.startTime = hospitalRecord.getStartTime();
            tempInfo.endTime = hospitalRecord.getEndTime();
            tempInfo.description = hospitalRecord.getDescription();
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

    @RequestMapping(value = "admin/hospitalRecord",method = RequestMethod.PUT)
    @ResponseBody
    public String updateHospitalRecord(@RequestBody HospitalRecord hospitalRecord){
        hospitalRecordService.updateHospitalRecord(hospitalRecord);
        return " Update success";
    }


    @RequestMapping(value = "admin/hospitalRecord", method = RequestMethod.POST)
    @ResponseBody
    public String saveHospitalRecord(@RequestBody HospitalRecord hospitalRecord) {
        hospitalRecordService.saveHospitalRecord(hospitalRecord);
        return "success!";
    }

    @RequestMapping(value = "admin/hospitalRecord",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteHospitalRecord(@RequestBody HospitalRecord hospitalRecord) {
        Integer id = hospitalRecord.getId();
        hospitalRecordService.deleteHospitalRecord(id);
        return "{result:true}";
    }
}
