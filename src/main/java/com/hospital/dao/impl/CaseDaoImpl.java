package com.hospital.dao.impl;

import com.hospital.entity.Case;
import com.hospital.dao.CaseDao;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
@Repository
public class CaseDaoImpl implements CaseDao {

    @Autowired
    private SessionFactory sessionFactory;


    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public Case load(Integer id) {
        return (Case) getCurrentSession().load(Case.class, id);
    }

    public Case get(Integer id) {
        return (Case) getCurrentSession().get(Case.class, id);
    }

    public Case getByName(String caseName) {
        String hql = "from Case ca where ca.caseName=?";
        Query query = getCurrentSession().createQuery(hql);
        query.setString(0, caseName);
        return (Case) query.list().get(0);
    }

    public List<Case> findAll() {
        String hql = "from Case";
        Query query = getCurrentSession().createQuery(hql);
        return query.list();
    }

    //查找数据？
    public void persist(Case entity) {
        getCurrentSession().persist(entity);
    }

    //插入数据
    public Integer save(Case entity) {
        return (Integer) getCurrentSession().save(entity);
    }

    //更新数据
    public void update(Case entity) {
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
            Case case_s = (Case) session.load(Case.class, id);
            session.delete(case_s);
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