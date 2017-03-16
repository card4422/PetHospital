package com.hospital.service.impl;

import com.hospital.entity.User;
import com.hospital.dao.UserDao;
import com.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userRepository;

    public Integer saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUser(){
        List list = userRepository.findAll();
        return list;
    }

    public User getUser(String name){
        return userRepository.getByName(name);
    }

    public void deleteUser(Integer id){
        userRepository.delete(id);
    }

    public void updateUser(User user){
        userRepository.update(user);
    }
}
