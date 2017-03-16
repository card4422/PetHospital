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
        return (Room) getCurrentSession().load(Room.class, id);
    }

    public Room get(Integer id) {
        return (Room) getCurrentSession().get(Room.class, id);
    }

    public Room getByName(String roomName) {
        String hql = "from Room roo where roo.roomName=?";
        Query query = getCurrentSession().createQuery(hql);
        query.setString(0, roomName);
        return (Room) query.list().get(0);
    }

    public List<Room> findAll() {
        String hql = "from Room";
        Query query = getCurrentSession().createQuery(hql);
        return query.list();
    }

    //查找数据？
    public void persist(Room entity) {
        getCurrentSession().persist(entity);
    }

    //插入数据
    public Integer save(Room entity) {
        return (Integer) getCurrentSession().save(entity);
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