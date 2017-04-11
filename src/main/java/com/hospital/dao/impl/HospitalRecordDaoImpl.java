package com.hospital.dao.impl;

import com.hospital.entity.HospitalRecord;
import com.hospital.dao.HospitalRecordDao;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
@Repository
public class HospitalRecordDaoImpl implements HospitalRecordDao {

    @Autowired
    private SessionFactory sessionFactory;


    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public HospitalRecord load(Integer id) {
        return (HospitalRecord) getCurrentSession().load(HospitalRecord.class, id);
    }

    public HospitalRecord get(Integer id) {
        return (HospitalRecord) getCurrentSession().get(HospitalRecord.class, id);
    }

    public List<HospitalRecord> findAll() {
        String hql = "from HospitalRecord";
        Query query = getCurrentSession().createQuery(hql);
        return query.list();
    }

    //查找数据？
    public void persist(HospitalRecord entity) {
        getCurrentSession().persist(entity);
    }

    //插入数据
    public Integer save(HospitalRecord entity) {
        return (Integer) getCurrentSession().save(entity);
    }

    //更新数据
    public void update(HospitalRecord entity) {
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
            HospitalRecord hospitalRecord = (HospitalRecord) session.load(HospitalRecord.class, id);
            session.delete(hospitalRecord);
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