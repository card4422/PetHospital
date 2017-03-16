package com.hospital.dao;

import com.hospital.entity.Room;

/**
 * Created by Jimmy on 2017/3/11.
 */
public interface RoomDao extends DomainDao<Room, Integer> {
    Room getByName(String name);
}