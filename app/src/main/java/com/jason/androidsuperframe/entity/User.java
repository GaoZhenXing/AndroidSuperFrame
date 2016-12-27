package com.jason.androidsuperframe.entity;

/**
 * 项目名称：AndroidSuperFrame
 * 〈用户实体类〉
 * 〈用户实体类〉
 * 创建人：JasonGao
 * 创建日期：2016/12/27.16:03
 */

public class User {

    private String name;
    private String phone;
    private int age;
    private String sex;

    public User() {
    }

    public User(String name, String phone, int age, String sex) {
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
