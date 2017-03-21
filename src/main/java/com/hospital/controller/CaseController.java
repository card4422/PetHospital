package com.hospital.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.entity.Case;
import com.hospital.entity.CaseResource;
import com.hospital.service.CaseResourceService;
import com.hospital.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Jimmy on 2017/3/17.
 */
@Controller
@RequestMapping("/")
public class CaseController {
    @Autowired
    private CaseService caseService;
    private CaseResourceService caseResourceService;



    @RequestMapping(value = "admin/case/{page}",method = RequestMethod.GET)
    @ResponseBody
    public String getCases(@PathVariable String page) {
        int pages = Integer.parseInt(page);
        List cases = caseService.getAllCase();
        List<Case> subcases = null;
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
            Integer Id;
            String caseName;
            Integer symptom;
            Integer examination;
            Integer result;
            Integer method;
        }
        List<templateInfo> result = new ArrayList<templateInfo>();
        for (Case c : subcases) {
            templateInfo tempInfo = new templateInfo();//必须放在循环内
            tempInfo.Id = c.getId();
            tempInfo.caseName = c.getCaseName();
            tempInfo.symptom = c.getSymptom();
            tempInfo.examination = c.getExam();
            tempInfo.result = c.getResult();
            tempInfo.method = c.getMethod();
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
        return "{\"data\":"+json+",\"pages\":"+page+"}";
    }

    @RequestMapping(value = "admin/case",method = RequestMethod.PUT)
    @ResponseBody
    public String updateCase(@RequestBody Case c){
        caseService.updateCase(c);
        return " Update success";
    }

    @RequestMapping(value = "admin/case",method = RequestMethod.POST)
    @ResponseBody
    public String saveCase(@RequestBody Case c){
        caseService.saveCase(c);
        return "success!";
    }

    @RequestMapping(value = "admin/case",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteCase(@RequestBody Case c) {
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
        return "{result:true}";
    }
}
