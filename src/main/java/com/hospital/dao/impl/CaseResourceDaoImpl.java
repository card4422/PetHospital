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
        return (CaseResource) getCurrentSession().load(CaseResource.class, id);
    }

    public CaseResource get(Integer id) {
        return (CaseResource) getCurrentSession().get(CaseResource.class, id);
    }

    public List<CaseResource> findAll() {
        String hql = "from CaseResource";
        Query query = getCurrentSession().createQuery(hql);
        return query.list();
    }

    //查找数据？
    public void persist(CaseResource entity) {
        getCurrentSession().persist(entity);
    }

    //插入数据
    public Integer save(CaseResource entity) {
        return (Integer) getCurrentSession().save(entity);
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

    //关闭session
    public void close(){
        getCurrentSession().close();
    }
}