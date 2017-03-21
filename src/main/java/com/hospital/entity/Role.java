package com.hospital.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

/**
 * Created by zhuzheng on 17/3/21.
 */
@Entity
public class Role {
    private int id;
    private String roomAccess;

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
    @Column(name = "room_access", nullable = true, length = 255)
    public String getRoomAccess() {
        return roomAccess;
    }

    public void setRoomAccess(String roomAccess) {
        this.roomAccess = roomAccess;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (id != role.id) return false;
        if (roomAccess != null ? !roomAccess.equals(role.roomAccess) : role.roomAccess != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (roomAccess != null ? roomAccess.hashCode() : 0);
        return result;
    }
}
