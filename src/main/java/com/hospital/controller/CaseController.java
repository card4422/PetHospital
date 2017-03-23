package com.hospital.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.entity.CaseEntity;
import com.hospital.entity.CaseResource;
import com.hospital.service.CaseResourceService;
import com.hospital.service.CaseService;
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
public class CaseController {
    @Autowired
    private CaseService caseService;
    @Autowired
    private CaseResourceService caseResourceService;

    @RequestMapping(value = "admin/case/{page}",method = RequestMethod.GET)
    @ResponseBody
    public String getCases(@PathVariable String page) {
        int pages = Integer.parseInt(page);
        List cases = caseService.getAllCase();
        List<CaseEntity> subcases = null;
        int total = (cases.size()-1)/10+1;
        int fromIndex = (pages - 1) * 10;
        if (cases.size() >= fromIndex) {
            int toIndex = pages * 10;
            if (cases.size() >= toIndex) {
                subcases = cases.subList(fromIndex, toIndex);
            } else {
                subcases = cases.subList(fromIndex, cases.size());
            }
        }
        class templateInfo {
            Integer id;
            String caseName;
            CaseResource symptom;
            CaseResource exam;
            CaseResource result;
            CaseResource method;
        }
        List<templateInfo> result = new ArrayList<templateInfo>();
        for (CaseEntity c : subcases) {
            templateInfo tempInfo = new templateInfo();//必须放在循环内
            tempInfo.id = c.getId();
            tempInfo.caseName = c.getCaseName();
            tempInfo.symptom = caseResourceService.getById(c.getSymptom());
            tempInfo.exam = caseResourceService.getById(c.getExam());
            tempInfo.result = caseResourceService.getById(c.getResult());
            tempInfo.method = caseResourceService.getById(c.getMethod());
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
        return "{\"data\":"+json+",\"pages\":"+total+"}";
    }

    @RequestMapping(value = "admin/case",method = RequestMethod.PUT)
    @ResponseBody
    public String updateCase(@RequestBody CaseEntity c){
        caseService.updateCase(c);
        return " Update success";
    }

    @RequestMapping(value = "admin/case",method = RequestMethod.POST)
    @ResponseBody
    public String saveCase(@RequestBody CaseEntity c){
        caseService.saveCase(c);
        return "success!";
    }

    @RequestMapping(value = "admin/case",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteCase(@RequestBody CaseEntity c) {
        Integer id = c.getId();
        caseService.deleteCase(id);
        return "{result:true}";
    }

    //SYMPTOM
    @RequestMapping(value = "admin/case/symptom",method = RequestMethod.PUT)
    @ResponseBody
    public String updateSymptom(@RequestBody CaseResource caseResource){
        caseResourceService.updateCaseResource(caseResource);
        return " Update success";
    }

    @RequestMapping(value = "admin/case/symptom",method = RequestMethod.POST)
    @ResponseBody
    public String saveSymptom(@RequestBody CaseResource caseResource){
        caseResourceService.saveCaseResource(caseResource);
        return "success!";
    }

    @RequestMapping(value = "admin/case/symptom",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteSymptom(@RequestBody CaseResource caseResource) {
        Integer id = caseResource.getId();
        caseResourceService.deleteCaseResource(id);
        return "{result:true}";
    }

    //EXAMINATION
    @RequestMapping(value = "admin/case/examination",method = RequestMethod.PUT)
    @ResponseBody
    public String updateExamination(@RequestBody CaseResource caseResource){
        caseResourceService.updateCaseResource(caseResource);
        return " Update success";
    }

    @RequestMapping(value = "admin/case/examination",method = RequestMethod.POST)
    @ResponseBody
    public String saveExamination(@RequestBody CaseResource caseResource){
        caseResourceService.saveCaseResource(caseResource);
        return "success!";
    }

    @RequestMapping(value = "admin/case/examination",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteExamination(@RequestBody CaseResource caseResource) {
        Integer id = caseResource.getId();
        caseResourceService.deleteCaseResource(id);
        return "{result:true}";
    }

    //RESULT
    @RequestMapping(value = "admin/case/result",method = RequestMethod.PUT)
    @ResponseBody
    public String updateResult(@RequestBody CaseResource caseResource){
        caseResourceService.updateCaseResource(caseResource);
        return " Update success";
    }

    @RequestMapping(value = "admin/case/result",method = RequestMethod.POST)
    @ResponseBody
    public String saveResult(@RequestBody CaseResource caseResource){
        caseResourceService.saveCaseResource(caseResource);
        return "success!";
    }

    @RequestMapping(value = "admin/case/result",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteResult(@RequestBody CaseResource caseResource) {
        Integer id = caseResource.getId();
        caseResourceService.deleteCaseResource(id);
        return "{result:true}";
    }

    //METHOD
    @RequestMapping(value = "admin/case/method",method = RequestMethod.PUT)
    @ResponseBody
    public String updateMethod(@RequestBody CaseResource caseResource){
        caseResourceService.updateCaseResource(caseResource);
        return " Update success";
    }

    @RequestMapping(value = "admin/case/method",method = RequestMethod.POST)
    @ResponseBody
    public String saveMethod(@RequestBody CaseResource caseResource){
        caseResourceService.saveCaseResource(caseResource);
        return "success!";
    }

    @RequestMapping(value = "admin/case/method",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteMethod(@RequestBody CaseResource caseResource) {
        Integer id = caseResource.getId();
        caseResourceService.deleteCaseResource(id);
        return "{\"result\":true}";
    }
}
