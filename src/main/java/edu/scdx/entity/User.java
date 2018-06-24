package edu.scdx.entity;

/**
 * Created by zhou on 2017-07-22.
 *
 * 用户实体类以及基本的构造函数get、set方法
 *
 */
public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String birthday;
    private String phone;
    private String address;
    private String qq;

    public User() {
        this.id = -1;
        this.name = "";
        this.email = "";
        this.password = "";
        this.birthday = "";
        this.phone = "";
        this.address = "";
        this.qq = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }
}