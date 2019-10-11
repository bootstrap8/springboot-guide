package com.fit.h2.user.controller;

import com.fit.common.response.ResponseVo;
import com.fit.h2.user.dao.entity.UserEntity;
import com.fit.h2.user.service.UserService;
import io.swagger.annotations.Api;
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
@Api(value = "用户管理", description = "UserController")
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