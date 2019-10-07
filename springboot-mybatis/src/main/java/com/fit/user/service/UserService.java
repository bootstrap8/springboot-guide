package com.fit.user.service;

import com.fit.common.response.ResponseVo;
import com.fit.user.dao.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-10-07
 */
public interface UserService {

    int addUser(UserEntity user);

    ResponseVo queryAllUsers();

    List<UserEntity> queryUsersByName(List<String> names);

//    List<UserEntity> querySthUsersByName(QueryVo queryVo);

    List<UserEntity> queryUsersByMap(Map map);

    long queryMaxUserId();

    int insertUsersByTable(String table, List<UserEntity> users);
}
