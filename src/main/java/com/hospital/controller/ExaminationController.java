package com.hospital.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.entity.Examination;
import com.hospital.service.ExaminationService;
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
public class ExaminationController {
    @Autowired
    private ExaminationService examinationService;

    @RequestMapping(value = "admin/examination/{page}", method = RequestMethod.GET)
    @ResponseBody
    public String getExamination(@PathVariable String page) {
        int pages = Integer.parseInt(page);
        List examinations = examinationService.getAllExamination();
        List<Examination> subexaminations = null;
        int total = (examinations.size()-1)/10+1;
        int fromIndex = (pages - 1) * 10;
        if (examinations.size() >= fromIndex) {
            int toIndex = pages * 10;
            if (examinations.size() >= toIndex) {
                subexaminations = examinations.subList(fromIndex, toIndex);
            } else {
                subexaminations = examinations.subList(fromIndex, examinations.size());
            }
        }
        class templateInfo {
            Integer id;
            String examinationName;
            Float examinationPrice;
            String description;
        }
        List<templateInfo> result = new ArrayList<templateInfo>();
        for (Examination examination : subexaminations) {
            templateInfo tempInfo = new templateInfo();//必须放在循环内
            tempInfo.id = examination.getId();
            tempInfo.examinationName = examination.getExaminationName();
            tempInfo.examinationPrice = examination.getExaminationPrice();
            tempInfo.description = examination.getDescription();
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

    @RequestMapping(value = "admin/examination",method = RequestMethod.PUT)
    @ResponseBody
    public String updateExamination(@RequestBody Examination examination){
        examinationService.updateExamination(examination);
        return " Update success";
    }


    @RequestMapping(value = "admin/examination", method = RequestMethod.POST)
    @ResponseBody
    public String saveExamination(@RequestBody Examination examination) {
        examinationService.saveExamination(examination);
        return "success!";
    }

    @RequestMapping(value = "admin/examination",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteExamination(@RequestBody Examination examination) {
        Integer id = examination.getId();
        examinationService.deleteExamination(id);
        return "{\"result\":true}";
    }
}
