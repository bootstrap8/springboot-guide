package com.fit.h2.user.service;

import com.fit.common.response.ResponseVo;
import com.fit.h2.user.dao.entity.UserEntity;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-10-08
 */
public interface UserService {

    ResponseVo queryUsers();

    ResponseVo addUser(UserEntity userEntity);
}
