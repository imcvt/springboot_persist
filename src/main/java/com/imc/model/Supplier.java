package com.imc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * @author luoly
 * @date 2018/10/23 11:42
 * @description
 */
@Entity
@Table(name = "supplier")
public class Supplier implements Serializable{

    public Supplier() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id; // 主键ID
    private String name; // 姓名
    @Column(name = "createtime")
    private Date createTime;
    private Integer sex;
    private Integer age;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
