package com.hospital.dao.impl;

import com.hospital.entity.CaseResource;
import com.hospital.dao.CaseResourceDao;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
@Repository
public class CaseResourceDaoImpl implements CaseResourceDao {

    @Autowired
    private SessionFactory sessionFactory;


    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public CaseResource load(Integer id) {
        Session session = getCurrentSession();
        try {
            return (CaseResource) session.load(CaseResource.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public CaseResource get(Integer id) {
        Session session = getCurrentSession();
        try {
            return (CaseResource) session.get(CaseResource.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public List<CaseResource> findAll() {
        Session session = getCurrentSession();
        try {
            String hql = "from CaseResource";
            Query query = session.createQuery(hql);
            return query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    //查找数据？
    public void persist(CaseResource entity) {
        Session session = getCurrentSession();
        try {
            session.persist(entity);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    //插入数据
    public Integer save(CaseResource entity) {
        Session session = getCurrentSession();
        try {
            return (Integer) session.save(entity);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return -1;
    }

    //更新数据
    public void update(CaseResource entity) {
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
            CaseResource caseResource = (CaseResource) session.load(CaseResource.class, id);
            session.delete(caseResource);
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