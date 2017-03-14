package com.hospital.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.entity.User;
import com.hospital.dao.UserDao;
import com.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userRepository;

    public Integer saveUser() {
//        User user = new User();
        //json数据中属性名要与User实体类的名字对应
        String json = "{\"userName\":\"root\",\"userPwd\":\"root\",\"userType\":1}";
        ObjectMapper objectMapper = new ObjectMapper();
        User user = null;
        try {
            user = objectMapper.readValue(json, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userRepository.save(user);
    }

    public List<User> getAllUser(){
        List list = userRepository.findAll();
        return list;
    }

    public User getUser(String name){
        return userRepository.getByName(name);
    }
}
