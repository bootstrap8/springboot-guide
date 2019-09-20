package com.fit.bean;

import lombok.Data;

import java.util.Date;


@Data
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String address;
    private Date birthday;
}
