package com.hospital.entity;

import javax.persistence.*;

/**
 * Created by Jimmy on 2017/3/16.
 */
@Entity
@IdClass(UserPK.class)
public class User {
    private int id;
    private String userName;
    private String userPwd;
    private Integer userType;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "user_name", nullable = false, insertable = true, updatable = true, length = 255)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_pwd", nullable = true, insertable = true, updatable = true, length = 255)
    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Basic
    @Column(name = "user_type", nullable = true, insertable = true, updatable = true)
    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (userPwd != null ? !userPwd.equals(user.userPwd) : user.userPwd != null) return false;
        if (userType != null ? !userType.equals(user.userType) : user.userType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPwd != null ? userPwd.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        return result;
    }
}
