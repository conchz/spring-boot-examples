package com.github.dolphineor.spring.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created on 2015-09-13.
 *
 * @author dolphineor
 */
@Entity
@Table(name = "TBL_USER")
public class UserEntity extends AbstractId implements Serializable {

    private String username;

    private int age;

    private int gender;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
