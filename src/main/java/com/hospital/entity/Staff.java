package com.hospital.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

/**
 * Created by zhuzheng on 17/3/21.
 */
@Entity
public class Staff {
    private int id;
    private String staffName;
    private String title;
    private Integer roomId;

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
    @Column(name = "staff_name", nullable = true, length = 255)
    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "room_id", nullable = true)
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Staff staff = (Staff) o;

        if (id != staff.id) return false;
        if (staffName != null ? !staffName.equals(staff.staffName) : staff.staffName != null) return false;
        if (title != null ? !title.equals(staff.title) : staff.title != null) return false;
        if (roomId != null ? !roomId.equals(staff.roomId) : staff.roomId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (staffName != null ? staffName.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (roomId != null ? roomId.hashCode() : 0);
        return result;
    }
}
