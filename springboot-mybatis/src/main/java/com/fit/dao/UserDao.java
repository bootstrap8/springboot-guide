package com.fit.dao;

import com.fit.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {

    int insert(User user);

    List<User> queryAllUsers();

    List<User> queryUsersByName(List<String> names);

    List<User> querySthUsersByName(@Param("columns") String columns, @Param("names") List<String> names);

    List<User> queryUsersByMap(Map map);
}
