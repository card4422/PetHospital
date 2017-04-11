package com.hospital.dao.impl;

import com.hospital.entity.Room;
import com.hospital.dao.RoomDao;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
@Repository
public class RoomDaoImpl implements RoomDao {

    @Autowired
    private SessionFactory sessionFactory;


    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public Room load(Integer id) {
        Session session = getCurrentSession();
        try {
            return (Room) session.load(Room.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public Room get(Integer id) {
        Session session = getCurrentSession();
        try {
            return (Room) session.get(Room.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public Room getByName(String roomName) {
        Session session = getCurrentSession();
        try {
            String hql = "from Room roo where roo.roomName=?";
            Query query = session.createQuery(hql);
            query.setString(0, roomName);
            return (Room) query.list().get(0);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public List<Room> findAll() {
        Session session = getCurrentSession();
        try {
            String hql = "from Room";
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
    public void persist(Room entity) {
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
    public Integer save(Room entity) {
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
    public void update(Room entity) {
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
            Room room = (Room) session.load(Room.class, id);
            session.delete(room);
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