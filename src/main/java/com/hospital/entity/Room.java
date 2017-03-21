package com.hospital.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

/**
 * Created by zhuzheng on 17/3/21.
 */
@Entity
public class Room {
    private int id;
    private String roomName;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "room_name", nullable = true, length = 255)
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (id != room.id) return false;
        if (roomName != null ? !roomName.equals(room.roomName) : room.roomName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (roomName != null ? roomName.hashCode() : 0);
        return result;
    }
}
