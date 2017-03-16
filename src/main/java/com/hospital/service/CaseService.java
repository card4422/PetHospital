package com.hospital.service;

import com.hospital.entity.Case;

import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
public interface CaseService {
    Integer saveCase(Case case_s);

    List<Case> getAllCase();

    Case getCase(String name);

    void deleteCase(Integer id);

    void updateCase(Case case_s);

}
