package com.hospital.service;

import com.hospital.entity.CaseEntity;

import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
public interface CaseService {
    Integer saveCase(CaseEntity case_Entity_s);

    List<CaseEntity> getAllCase();

    CaseEntity getCase(String name);

    void deleteCase(Integer id);

    void updateCase(CaseEntity case_Entity_s);

}
