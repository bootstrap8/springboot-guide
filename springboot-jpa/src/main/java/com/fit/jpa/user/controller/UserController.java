package com.fit.jpa.user.controller;

import com.fit.common.response.ResponseVo;
import com.fit.jpa.user.repository.entity.UserEntity;
import com.fit.jpa.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-10-08
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/queryUsers", method = RequestMethod.POST)
    public ResponseVo queryUsers() {
        return userService.queryUsers();
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseVo addUser(@RequestBody UserEntity user) {
        return userService.addUser(user);
    }
}
