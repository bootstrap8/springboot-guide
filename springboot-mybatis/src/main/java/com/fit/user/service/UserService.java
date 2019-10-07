package com.fit.user.service;

import com.fit.user.dao.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-10-07
 */
public interface UserService {

    int addUser(User user);

    List<User> queryAllUsers();

    List<User> queryUsersByName(List<String> names);

//    List<User> querySthUsersByName(QueryVo queryVo);

    List<User> queryUsersByMap(Map map);

    long queryMaxUserId();

    int insertUsersByTable(String table, List<User> users);
}
