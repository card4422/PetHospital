package com.hospital.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by zhuzheng on 17/3/16.
 */
public class RolePK implements Serializable {
    private int id;
    private int roleType;

    @Column(name = "id", nullable = false)
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "role_type", nullable = false)
    @Id
    public int getRoleType() {
        return roleType;
    }

    public void setRoleType(int roleType) {
        this.roleType = roleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolePK rolePK = (RolePK) o;

        if (id != rolePK.id) return false;
        if (roleType != rolePK.roleType) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + roleType;
        return result;
    }
}
