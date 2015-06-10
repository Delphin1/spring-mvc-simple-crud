package com.belkam.mvc_test.model;

import javax.persistence.*;

/**
 * Created by tsg on 05.06.2015.
 */
@Entity
@Table(name="RES_USERS")
public class User {
    @Id
    @GeneratedValue
    private long    userId;

    @Column(nullable = false,unique = true)
    private String  userName;

    private String  fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    private String  userPassword;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean isDeleted;


//----------------------------------------------------------------------------------
    public String toString() {
        return String.format("User id: [%d] , name: [%s], fullname: [%s], password: [$s]", getUserId(), getUserName(), getFullName(), getUserPassword());
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public User(String userName, String userPassword, String fullName,  boolean isDeleted) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.isDeleted = isDeleted;
        this.fullName = fullName;
    }

    public User(String userName, String userPassword, String fullName) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.isDeleted = false;
        this.fullName = fullName;
    }

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.isDeleted = false;
        this.fullName = "";
    }


    public User() {};
}
