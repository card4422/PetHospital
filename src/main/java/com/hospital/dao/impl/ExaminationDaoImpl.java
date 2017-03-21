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
        return (Examination) getCurrentSession().load(Examination.class, id);
    }

    public Examination get(Integer id) {
        return (Examination) getCurrentSession().get(Examination.class, id);
    }

    public Examination getByName(String examinationName) {
        String hql = "from Examination exam where exam.examinationName=?";
        Query query = getCurrentSession().createQuery(hql);
        query.setString(0, examinationName);
        return (Examination) query.list().get(0);
    }

    public List<Examination> findAll() {
        String hql = "from Examination";
        Query query = getCurrentSession().createQuery(hql);
        List list =  query.list();
        return list;
    }

    //查找数据？
    public void persist(Examination entity) {
        getCurrentSession().persist(entity);
    }

    //插入数据
    public Integer save(Examination entity) {
        return (Integer) getCurrentSession().save(entity);
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