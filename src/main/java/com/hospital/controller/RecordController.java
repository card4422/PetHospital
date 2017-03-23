package com.hospital.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.entity.Record;
import com.hospital.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jimmy on 2017/3/16.
 */

@Controller
@RequestMapping("/")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @RequestMapping(value = "admin/record/{page}", method = RequestMethod.GET)
    @ResponseBody
    public String getRecord(@PathVariable String page) {
        int pages = Integer.parseInt(page);
        List records = recordService.getAllRecord();
        List<Record> subrecords = null;
        int fromIndex = (pages - 1) * 10;
        int total = (records.size()-1)/10+1;
        if (records.size() >= fromIndex) {
            int toIndex = pages * 10;
            if (records.size() >= toIndex) {
                subrecords = records.subList(fromIndex, toIndex);
            } else {
                subrecords = records.subList(fromIndex, records.size());
            }
        }
        class templateInfo {
            Integer id;
            Date time;
            String patient;
            String petType;
            String description;
            Float price;
        }
        List<templateInfo> result = new ArrayList<templateInfo>();
        for (Record record : subrecords) {
            templateInfo tempInfo = new templateInfo();//必须放在循环内
            tempInfo.id = record.getId();
            tempInfo.time = record.getTime();
            tempInfo.patient = record.getPatient();
            tempInfo.petType = record.getPetType();
            tempInfo.description = record.getDescription();
            tempInfo.price = record.getPrice();
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

    @RequestMapping(value = "admin/record", method = RequestMethod.POST)
    @ResponseBody
    public String saveRecord(@RequestBody Record record) {
        recordService.saveRecord(record);
        return "success!";
    }

    @RequestMapping(value = "admin/record",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteRecord(@RequestBody Record record) {
        Integer id = record.getId();
        recordService.deleteRecord(id);
        return "{\"result\":true}";
    }
}
