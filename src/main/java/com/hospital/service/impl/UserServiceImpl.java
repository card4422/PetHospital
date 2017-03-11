package com.hospital.service.impl;

import com.hospital.entity.User;
import com.hospital.repository.UserRepository;
import com.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jimmy on 2017/3/11.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public Long saveUser() {
        User user = new User();
        user.setName("root");
        user.setPassword("root");
        user.setType(1);
        return userRepository.save(user);
    }
}