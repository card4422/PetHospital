package com.hospital.service.impl;

import com.hospital.entity.Case;
import com.hospital.dao.CaseDao;
import com.hospital.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
@Service
public class CaseServiceImpl implements CaseService {

    @Autowired
    private CaseDao caseRepository;

    public Integer saveCase(Case case_s) {
        return caseRepository.save(case_s);
    }

    public List<Case> getAllCase() {
        List list = caseRepository.findAll();
        return list;
    }

    public Case getCase(String name) {
        return caseRepository.getByName(name);
    }

    public void deleteCase(Integer id) {
        caseRepository.delete(id);
    }

    public void updateCase(Case case_s) {
        caseRepository.update(case_s);
    }
}
