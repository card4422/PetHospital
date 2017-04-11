package com.hospital.dao.impl;

import com.hospital.entity.Role;
import com.hospital.dao.RoleDao;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;


    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public Role load(Integer id) {
        try {
            return (Role) getCurrentSession().load(Role.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            getCurrentSession().close();
        }
        return null;
    }

    public Role get(Integer id) {
        try {
            return (Role) getCurrentSession().get(Role.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            getCurrentSession().close();
        }
        return null;
    }

    public List<Role> findAll() {
        try {
            String hql = "from Role";
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
    public void persist(Role entity) {
        try {
            getCurrentSession().persist(entity);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            getCurrentSession().close();
        }
    }

    //插入数据
    public Integer save(Role entity) {
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
    public void update(Role entity) {
        try {
            Session session = getCurrentSession();
            Transaction tx = session.beginTransaction();
            session.update(entity);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    //删除数据
    public void delete(Integer id) {
        try {
            Session session = getCurrentSession();
            Transaction tx = session.beginTransaction();
            Role role = (Role) session.load(Role.class, id);
            session.delete(role);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    //清理
    public void flush() {
        getCurrentSession().flush();
    }
}