package com.hospital.service.impl;

import com.hospital.entity.CaseResource;
import com.hospital.dao.CaseResourceDao;
import com.hospital.service.CaseResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
@Service
public class CaseResourceServiceImpl implements CaseResourceService {

    @Autowired
    private CaseResourceDao caseResourceRepository;

    public Integer saveCaseResource(CaseResource caseResource) {
        return caseResourceRepository.save(caseResource);
    }

    public List<CaseResource> getAllCaseResource() {
        List list = caseResourceRepository.findAll();
        return list;
    }

//    public CaseResource getCaseResource(String name){
//        return caseResourceRepository.getByName(name);
//    }

    public void deleteCaseResource(Integer id) {
        caseResourceRepository.delete(id);
    }

    public void updateCaseResource(CaseResource caseResource) {
        caseResourceRepository.update(caseResource);
    }
}
