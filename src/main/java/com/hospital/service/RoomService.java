package com.hospital.service;

import com.hospital.entity.Room;

import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
public interface RoomService {
    Integer saveRoom(Room room);

    List<Room> getAllRoom();

    Room getRoom(String name);

    void deleteRoom(Integer id);

    void updateRoom(Room room);

}
