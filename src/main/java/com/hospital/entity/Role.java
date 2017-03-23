package com.hospital.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Jimmy on 2017/3/23.
 */
@Entity
public class Role {
    private int id;
    private String roomAccess;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "room_access", nullable = true, insertable = true, updatable = true, length = 255)
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
