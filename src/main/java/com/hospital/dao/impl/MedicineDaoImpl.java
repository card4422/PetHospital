package com.hospital.dao.impl;

import com.hospital.dao.MedicineDao;
import com.hospital.entity.Medicine;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
@Repository
public class MedicineDaoImpl implements MedicineDao {

    @Autowired
    private SessionFactory sessionFactory;


    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public Medicine load(Integer id) {
        return (Medicine) getCurrentSession().load(Medicine.class, id);
    }

    public Medicine get(Integer id) {
        return (Medicine) getCurrentSession().get(Medicine.class, id);
    }

    public Medicine getByName(String medicineName) {
        String hql = "from Medicine med where med.medicineName=?";
        Query query = getCurrentSession().createQuery(hql);
        query.setString(0, medicineName);
        return (Medicine) query.list().get(0);
    }

    public List<Medicine> findAll() {
        String hql = "from Medicine";
        Query query = getCurrentSession().createQuery(hql);
        return query.list();
    }

    //查找数据？
    public void persist(Medicine entity) {
        getCurrentSession().persist(entity);
    }

    //插入数据
    public Integer save(Medicine entity) {
        return (Integer) getCurrentSession().save(entity);
    }

    //更新数据
    public void update(Medicine entity) {
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
            Medicine medicine = (Medicine) session.load(Medicine.class, id);
            session.delete(medicine);
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