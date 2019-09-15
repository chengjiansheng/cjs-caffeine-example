package com.cjs.example.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ChengJianSheng
 * @date 2019-09-15
 */
@Data
public class Teacher implements Serializable {

    private Integer id;

    private String name;

    public Teacher(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
