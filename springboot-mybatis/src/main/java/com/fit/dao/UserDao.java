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

    Long queryMaxUserId();

    /**
     * 动态根据表名插入，适用于月表
     * @param table
     * @param users
     * @return
     */
    int insertUsersByTable(@Param("table") String table, @Param("users") List<User> users);
}
