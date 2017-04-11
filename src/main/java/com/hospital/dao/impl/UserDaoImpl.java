package com.hospital.dao.impl;

import com.hospital.entity.User;
import com.hospital.dao.UserDao;
import org.hibernate.*;
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
        try {
            return (User) getCurrentSession().load(User.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            getCurrentSession().close();
        }
        return null;
    }

    public User get(Integer id) {
        try {
            return (User) getCurrentSession().get(User.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            getCurrentSession().close();
        }
        return null;
    }

    public User getByName(String userName){
        try {
            String hql = "from User u where u.userName=?";
            Query query = getCurrentSession().createQuery(hql);
            query.setString(0, userName);
            return (User) query.list().get(0);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            getCurrentSession().close();
        }
        return null;
    }

    public List<User> findAll() {
        try {
            String hql = "from User";
            Query query = getCurrentSession().createQuery(hql);
            return query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            getCurrentSession().close();
        }
        return null;
}

    //查找数据？
    public void persist(User entity) {
        try {
            getCurrentSession().persist(entity);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            getCurrentSession().close();
        }
    }

    //插入数据
    public Integer save(User entity) {
        try {
            return (Integer) getCurrentSession().save(entity);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            getCurrentSession().close();
        }
        return -1;
    }

    //更新数据
    public void update(User entity) {
        try {
            Session session = getCurrentSession();
            Transaction tx = session.beginTransaction();
            session.update(entity);
            tx.commit();
            session.close();
        }catch(HibernateException e){
            e.printStackTrace();
        }
    }

    //删除数据
    public void delete(Integer id) {
        try {
            Session session = getCurrentSession();
            Transaction tx = session.beginTransaction();
            User user = (User)session.load(User.class,id);
            session.delete(user);
            tx.commit();
            session.close();
        }catch(HibernateException e){
            e.printStackTrace();
        }
    }

    //清理
    public void flush() {
        getCurrentSession().flush();
    }
}