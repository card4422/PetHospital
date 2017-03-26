package com.hospital.service.impl;

import com.hospital.entity.Room;
import com.hospital.dao.RoomDao;
import com.hospital.service.RoomService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDao roomRepository;

    //log工厂
    private final Log log = LogFactory.getLog(getClass());

    public Integer saveRoom(Room room) {
        try {
            return roomRepository.save(room);
        } catch (HibernateException e) {
            log.error("在saveRoom出错了");
            log.error(e);
            e.printStackTrace();
        }
        return -1;
    }

    public List<Room> getAllRoom() {
        try {
            List list = roomRepository.findAll();
            return list;
        } catch (HibernateException e) {
            log.error("在getAllRoom出错了");
            log.error(e);
            e.printStackTrace();
        }
        return null;
    }

    public Room getRoom(String name) {
        try {
            return roomRepository.getByName(name);
        } catch (HibernateException e) {
            log.error("在getRoom出错了");
            log.error(e);
            e.printStackTrace();
        }
        return null;
    }

    public void deleteRoom(Integer id) {
        try {
            roomRepository.delete(id);
        } catch (HibernateException e) {
            log.error("在deleteRoom出错了");
            log.error(e);
            e.printStackTrace();
        }
    }

    public void updateRoom(Room room) {
        try {
            roomRepository.update(room);
        } catch (HibernateException e) {
            log.error("在updateRoom出错了");
            log.error(e);
            e.printStackTrace();
        }
    }
}
