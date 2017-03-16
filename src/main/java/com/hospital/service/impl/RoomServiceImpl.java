package com.hospital.service.impl;

import com.hospital.entity.Room;
import com.hospital.dao.RoomDao;
import com.hospital.service.RoomService;
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

    public Integer saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public List<Room> getAllRoom() {
        List list = roomRepository.findAll();
        return list;
    }

    public Room getRoom(String name) {
        return roomRepository.getByName(name);
    }

    public void deleteRoom(Integer id) {
        roomRepository.delete(id);
    }

    public void updateRoom(Room room) {
        roomRepository.update(room);
    }
}
