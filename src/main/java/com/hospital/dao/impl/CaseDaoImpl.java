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
        Session session = getCurrentSession();
        try {
            return (CaseEntity) session.load(CaseEntity.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public CaseEntity get(Integer id) {
        Session session = getCurrentSession();
        try {
            return (CaseEntity) session.get(CaseEntity.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public List<CaseEntity> getByName(String caseName) {
        Session session = getCurrentSession();
        try {
            String hql = "from CaseEntity ca where ca.caseName like ?";
            Query query = getCurrentSession().createQuery(hql);
            query.setString(0, "%" + caseName + "%");
            return query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public CaseEntity getByID(Integer id) {
        Session session = getCurrentSession();
        try {
            String hql = "from CaseEntity ca where ca.id=?";
            Query query = session.createQuery(hql);
            query.setInteger(0, id);
            return (CaseEntity) query.list().get(0);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public List<CaseEntity> getByClassification(String classification) {
        Session session = getCurrentSession();
        try {
            String hql = "from CaseEntity ca where ca.classification=?";
            Query query = session.createQuery(hql);
            query.setString(0, classification);
            return query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public List<CaseEntity> findAll() {
        Session session = getCurrentSession();
        try {
            String hql = "from CaseEntity ce";
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
    public void persist(CaseEntity entity) {
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
    public Integer save(CaseEntity entity) {
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
    public void update(CaseEntity entity) {
        try {
            Session session = getCurrentSession();
            Transaction tx = session.beginTransaction();
            session.update(entity);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
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
        } finally {
        }
    }

    //清理
    public void flush() {
        getCurrentSession().flush();
    }

}