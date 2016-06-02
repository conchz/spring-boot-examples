package com.github.lavenderx.springboot.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created on 2015-09-13.
 *
 * @author Baymax
 */
@Entity
@Table(name = "reactive.TBL_USER")
public class UserEntity extends AbstractId {

    @Column(columnDefinition = "VARCHAR(16)", unique = true, nullable = false)
    private String username;

    @Column(columnDefinition = "VARCHAR(16)", nullable = false)
    private String password;

    private int gender;

    private boolean isValid;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date birthday;

    @Column(columnDefinition = "VARCHAR(32)", unique = true, nullable = false)
    private String email;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
