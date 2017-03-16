package com.hospital.dao.impl;

import com.hospital.entity.Staff;
import com.hospital.dao.StaffDao;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
@Repository
public class StaffDaoImpl implements StaffDao {

    @Autowired
    private SessionFactory sessionFactory;


    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public Staff load(Integer id) {
        return (Staff) getCurrentSession().load(Staff.class, id);
    }

    public Staff get(Integer id) {
        return (Staff) getCurrentSession().get(Staff.class, id);
    }

    public Staff getByName(String staffName) {
        String hql = "from Staff staf where staf.staffName=?";
        Query query = getCurrentSession().createQuery(hql);
        query.setString(0, staffName);
        return (Staff) query.list().get(0);
    }

    public List<Staff> findAll() {
        String hql = "from Staff";
        Query query = getCurrentSession().createQuery(hql);
        return query.list();
    }

    //查找数据？
    public void persist(Staff entity) {
        getCurrentSession().persist(entity);
    }

    //插入数据
    public Integer save(Staff entity) {
        return (Integer) getCurrentSession().save(entity);
    }

    //更新数据
    public void update(Staff entity) {
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
            Staff staff = (Staff) session.load(Staff.class, id);
            session.delete(staff);
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