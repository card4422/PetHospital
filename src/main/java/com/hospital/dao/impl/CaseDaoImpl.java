package com.hospital.dao.impl;

import com.hospital.entity.CaseEntity;
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

    public CaseEntity load(Integer id) {
        return (CaseEntity) getCurrentSession().load(CaseEntity.class, id);
    }

    public CaseEntity get(Integer id) {
        return (CaseEntity) getCurrentSession().get(CaseEntity.class, id);
    }

    public List<CaseEntity> getByName(String caseName) {
        String hql = "from CaseEntity ca where ca.caseName=?";
        Query query = getCurrentSession().createQuery(hql);
        query.setString(0, caseName);
        return query.list();
    }

    public CaseEntity getByID(Integer id) {
        String hql = "from CaseEntity ca where ca.id=?";
        Query query = getCurrentSession().createQuery(hql);
        query.setInteger(0, id);
        return (CaseEntity) query.list().get(0);
    }

    public List<CaseEntity> getByClassification(String classification) {
        String hql = "from CaseEntity ca where ca.classification=?";
        Query query = getCurrentSession().createQuery(hql);
        query.setString(0, classification);
        return query.list();
    }

    public List<CaseEntity> findAll() {
        String hql = "from CaseEntity ce";
        Query query = getCurrentSession().createQuery(hql);
        return query.list();
    }

    //查找数据？
    public void persist(CaseEntity entity) {
        getCurrentSession().persist(entity);
    }

    //插入数据
    public Integer save(CaseEntity entity) {
        return (Integer) getCurrentSession().save(entity);
    }

    //更新数据
    public void update(CaseEntity entity) {
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
            CaseEntity caseEntity = (CaseEntity) session.load(CaseEntity.class, id);
            session.delete(caseEntity);
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