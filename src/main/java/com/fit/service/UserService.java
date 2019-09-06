package com.fit.service;

import com.fit.bean.QueryVo;
import com.fit.bean.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    int addUser(User user);

    List<User> queryAllUsers();

    List<User> queryUsersByName(List<String> names);

    List<User> querySthUsersByName(QueryVo queryVo);

    List<User> queryUsersByMap(Map map);

}
