package com.github.dolphineor.springboot.model.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created on 2015-09-13.
 *
 * @author dolphineor
 */
@Entity
@NamedEntityGraph(name = "reactive.TBL_USER")
public class UserEntity extends AbstractId {

    @Column(columnDefinition = "VARCHAR(16)", unique = true, nullable = false)
    private String userName;

    @Column(columnDefinition = "VARCHAR(16)", nullable = false)
    private String password;

    private int age;

    private int gender;

    private boolean isValid;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date birthday;

    private String email;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
