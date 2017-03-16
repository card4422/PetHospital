package com.hospital.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by zhuzheng on 17/3/16.
 */
public class RoomPK implements Serializable {
    private int id;
    private int roomType;

    @Column(name = "id", nullable = false)
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "room_type", nullable = false)
    @Id
    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomPK roomPK = (RoomPK) o;

        if (id != roomPK.id) return false;
        if (roomType != roomPK.roomType) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + roomType;
        return result;
    }
}
