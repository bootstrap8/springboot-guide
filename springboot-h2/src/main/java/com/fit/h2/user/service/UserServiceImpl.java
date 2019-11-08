package com.fit.h2.user.service;

import com.fit.common.response.ResponseVo;
import com.fit.h2.user.Poster;
import com.fit.h2.user.dao.UserDao;
import com.fit.h2.user.dao.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-10-08
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private Poster poster;

    @Override
    public ResponseVo queryUsers() {
        List<UserEntity> userList = userDao.queryAllUsers();
        return ResponseVo.okFrom(userList);
    }

    @Override
    public ResponseVo addUser(UserEntity userEntity) {
        return ResponseVo.okFrom(userDao.addUser(userEntity));
    }
}
