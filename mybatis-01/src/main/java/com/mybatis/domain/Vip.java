package com.mybatis.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-11-14 13:47:41
 */
public class Vip implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private Float height;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vip)) return false;
        Vip vip = (Vip) o;
        return Objects.equals(getId(), vip.getId()) &&
                Objects.equals(getName(), vip.getName()) &&
                Objects.equals(getAge(), vip.getAge()) &&
                Objects.equals(getSex(), vip.getSex()) &&
                Objects.equals(getHeight(), vip.getHeight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge(), getSex(), getHeight());
    }

    @Override
    public String toString() {
        return "Vip{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", height=" + height +
                '}';
    }
}
