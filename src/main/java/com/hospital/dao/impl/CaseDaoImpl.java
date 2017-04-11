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
        try {
            return (CaseEntity) getCurrentSession().load(CaseEntity.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            getCurrentSession().close();
        }
        return null;
    }

    public CaseEntity get(Integer id) {
        try {
            return (CaseEntity) getCurrentSession().get(CaseEntity.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            getCurrentSession().close();
        }
        return null;
    }

    public List<CaseEntity> getByName(String caseName) {
        try {
            String hql = "from CaseEntity ca where ca.caseName like ?";
            Query query = getCurrentSession().createQuery(hql);
            query.setString(0, "%" + caseName + "%");
            return query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            getCurrentSession().close();
        }
        return null;
    }

    public CaseEntity getByID(Integer id) {
        try {
            String hql = "from CaseEntity ca where ca.id=?";
            Query query = getCurrentSession().createQuery(hql);
            query.setInteger(0, id);
            return (CaseEntity) query.list().get(0);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            getCurrentSession().close();
        }
        return null;
    }

    public List<CaseEntity> getByClassification(String classification) {
        try {
            String hql = "from CaseEntity ca where ca.classification=?";
            Query query = getCurrentSession().createQuery(hql);
            query.setString(0, classification);
            return query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            getCurrentSession().close();
        }
        return null;
    }

    public List<CaseEntity> findAll() {
        try {
            String hql = "from CaseEntity ce";
            Query query = getCurrentSession().createQuery(hql);
            return query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            getCurrentSession().close();
        }
        return null;
    }

    //查找数据？
    public void persist(CaseEntity entity) {
        try {
            getCurrentSession().persist(entity);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            getCurrentSession().close();
        }
    }

    //插入数据
    public Integer save(CaseEntity entity) {
        try {
            return (Integer) getCurrentSession().save(entity);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            getCurrentSession().close();
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
            getCurrentSession().close();
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
            getCurrentSession().close();
        }
    }

    //清理
    public void flush() {
        getCurrentSession().flush();
    }

}