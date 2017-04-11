package com.hospital.dao.impl;

import com.hospital.entity.Examination;
import com.hospital.dao.ExaminationDao;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
@Repository
public class ExaminationDaoImpl implements ExaminationDao {

    @Autowired
    private SessionFactory sessionFactory;


    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public Examination load(Integer id) {
        Session session = getCurrentSession();
        try {
            return (Examination) session.load(Examination.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public Examination get(Integer id) {
        Session session = getCurrentSession();
        try {
            return (Examination) session.get(Examination.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public Examination getByName(String examinationName) {
        Session session = getCurrentSession();
        try {
            String hql = "from Examination exam where exam.examinationName=?";
            Query query = session.createQuery(hql);
            query.setString(0, examinationName);
            return (Examination) query.list().get(0);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public List<Examination> findAll() {
        Session session = getCurrentSession();
        try {
            String hql = "from Examination";
            Query query = session.createQuery(hql);
            List list = query.list();
            return list;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    //查找数据？
    public void persist(Examination entity) {
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
    public Integer save(Examination entity) {
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
    public void update(Examination entity) {
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
            Examination examination = (Examination) session.load(Examination.class, id);
            session.delete(examination);
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