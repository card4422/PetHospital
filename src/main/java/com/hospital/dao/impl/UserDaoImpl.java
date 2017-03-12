package com.hospital.dao.impl;

import com.hospital.entity.User;
import com.hospital.dao.UserDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;


    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public User load(Integer id) {
        return (User)getCurrentSession().load(User.class,id);
    }

    public User get(Integer id) {
        return (User)getCurrentSession().get(User.class,id);
    }

    public List<User> findAll() {
        return null;
    }

    //查找数据？
    public void persist(User entity) {
        getCurrentSession().persist(entity);
    }

    //插入数据
    public Integer save(User entity) {
        return (Integer)getCurrentSession().save(entity);
    }

    //更新数据
    public void saveOrUpdate(User entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    //删除数据
    public void delete(Integer id) {
        User user = load(id);
        getCurrentSession().delete(user);
    }

    //清理
    public void flush() {
        getCurrentSession().flush();
    }
}