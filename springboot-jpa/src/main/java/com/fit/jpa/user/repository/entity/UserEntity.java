package com.fit.jpa.user.repository.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-10-07
 */
@Data
@Entity
@Table(name = "tab_user")
public class UserEntity {
    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
}