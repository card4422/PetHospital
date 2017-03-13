package com.hospital.service.impl;

import com.hospital.entity.User;
import com.hospital.dao.UserDao;
import com.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jimmy on 2017/3/11.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userRepository;

    public Integer saveUser() {
        User user = new User();
        user.setUserName("root");
        user.setUserPwd("root");
        user.setUserType(1);
        return userRepository.save(user);
    }
}