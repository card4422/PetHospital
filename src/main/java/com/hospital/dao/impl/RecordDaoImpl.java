package com.hospital.dao.impl;

import com.hospital.entity.Record;
import com.hospital.dao.RecordDao;
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
        return (Record) getCurrentSession().load(Record.class, id);
    }

    public Record get(Integer id) {
        return (Record) getCurrentSession().get(Record.class, id);
    }

    public List<Record> findAll() {
        String hql = "from Record";
        Query query = getCurrentSession().createQuery(hql);
        return query.list();
    }

    //查找数据？
    public void persist(Record entity) {
        getCurrentSession().persist(entity);
    }

    //插入数据
    public Integer save(Record entity) {
        return (Integer) getCurrentSession().save(entity);
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