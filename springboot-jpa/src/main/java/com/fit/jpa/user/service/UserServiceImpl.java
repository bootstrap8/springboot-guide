package com.fit.jpa.user.service;

import com.fit.common.response.ResponseVo;
import com.fit.jpa.user.repository.UserRepository;
import com.fit.jpa.user.repository.entity.UserEntity;
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
    private UserRepository userRepository;

    @Override
    public ResponseVo queryUsers() {
        List<UserEntity> userList = userRepository.findAll();
        return ResponseVo.okFrom(userList);
    }

    @Override
    public ResponseVo addUser(UserEntity userEntity) {
        UserEntity saved = userRepository.save(userEntity);
        return ResponseVo.okFrom(saved);
    }
}
