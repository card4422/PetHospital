package com.hospital.service;

import com.hospital.entity.CaseResource;

import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
public interface CaseResourceService {
    Integer saveCaseResource(CaseResource caseResource);

    List<CaseResource> getAllCaseResource();

//    CaseResource getCaseResource(String name);

    void deleteCaseResource(Integer id);

    void updateCaseResource(CaseResource caseResource);

}
