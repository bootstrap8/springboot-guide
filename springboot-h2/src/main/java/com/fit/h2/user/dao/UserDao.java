package com.fit.h2.user.dao;

import com.fit.h2.user.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-10-07
 */
public interface UserDao {

    @Select({"select * from tab_user"})
    List<UserEntity> queryAllUsers();

    @Insert({"insert into tab_user (name, address) values (#{name}, #{address})"})
    int addUser(UserEntity userEntity);
}
