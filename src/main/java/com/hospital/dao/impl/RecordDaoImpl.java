package com.hospital.dao.impl;

import com.hospital.entity.Record;
import com.hospital.dao.RecordDao;
import com.mchange.v1.lang.NullUtils;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
@Repository
public class RecordDaoImpl implements RecordDao {

    @Autowired
    private SessionFactory sessionFactory;


    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public Record load(Integer id) {
        Session session = getCurrentSession();
        try {
            return (Record) session.load(Record.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public Record get(Integer id) {
        Session session = getCurrentSession();
        try {
            return (Record) session.get(Record.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public List<Record> findAll() {
        Session session = getCurrentSession();
        try {
            String hql = "from Record";
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
    public void persist(Record entity) {
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
    public Integer save(Record entity) {
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
    public void update(Record entity) {
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
            Record record = (Record) session.load(Record.class, id);
            session.delete(record);
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