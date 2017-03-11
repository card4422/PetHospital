package com.hospital.service.impl;

import com.hospital.service.TestService;
import org.springframework.stereotype.Service;

/**
 * Created by Jimmy on 2017/3/11.
 */
@Service
public class TestServiceImpl implements TestService {
    public String test() {
        return "test";
    }
}