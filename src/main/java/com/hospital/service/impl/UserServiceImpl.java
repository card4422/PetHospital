package com.hospital.service.impl;

import com.hospital.entity.User;
import com.hospital.dao.UserDao;
import com.hospital.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
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

    //log工厂
    private final Log log = LogFactory.getLog(getClass());

    public Integer saveUser(User user) {
        try {
            return userRepository.save(user);
        } catch (HibernateException e) {
            log.error("在saveUser出错了");
            log.error(e);
            e.printStackTrace();
        }
        return -1;
    }

    public List<User> getAllUser(){
        try {
            List list = userRepository.findAll();
            return list;
        } catch (HibernateException e) {
            log.error("在getAllUser出错了");
            log.error(e);
            e.printStackTrace();
        }
        return null;
    }

    public User getUser(String name){
        try {
            return userRepository.getByName(name);
        } catch (HibernateException e) {
            log.error("在getUser出错了");
            log.error(e);
            e.printStackTrace();
        }
        return null;
    }

    public void deleteUser(Integer id){
        try {
            userRepository.delete(id);
        } catch (HibernateException e) {
            log.error("在deleteUser出错了");
            log.error(e);
            e.printStackTrace();
        }
    }

    public void updateUser(User user){
        try {
            userRepository.update(user);
        } catch (HibernateException e) {
            log.error("在updateUser出错了");
            log.error(e);
            e.printStackTrace();
        }
    }
}
