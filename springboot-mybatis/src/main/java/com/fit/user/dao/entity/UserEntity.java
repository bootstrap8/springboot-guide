package com.fit.user.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserEntity {
    private Long id;
    private String name;
    private Integer age;
    private String address;
    private Date birthday;
}
