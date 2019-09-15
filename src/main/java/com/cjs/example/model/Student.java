package com.cjs.example.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ChengJianSheng
 * @date 2019-09-15
 */
@Data
public class Student implements Serializable {

    private Integer id;

    private String name;

    private Integer sex;

    private String desc;

    public Student(Integer id, String name, Integer sex, String desc) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.desc = desc;
    }
}
