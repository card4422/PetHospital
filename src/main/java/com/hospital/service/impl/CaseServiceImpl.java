package com.hospital.service.impl;

import com.hospital.entity.CaseEntity;
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

    public Integer saveCase(CaseEntity case_Entity_s) {
        return caseRepository.save(case_Entity_s);
    }

    public List<CaseEntity> getAllCase() {
        List list = caseRepository.findAll();
        return list;
    }

    public CaseEntity getCase(String name) {
        return caseRepository.getByName(name);
    }

    public void deleteCase(Integer id) {
        caseRepository.delete(id);
    }

    public void updateCase(CaseEntity case_Entity_s) {
        caseRepository.update(case_Entity_s);
    }
}
