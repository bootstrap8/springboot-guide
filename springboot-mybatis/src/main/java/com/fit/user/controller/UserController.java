package com.fit.user.controller;

import com.fit.user.dao.entity.User;
import com.fit.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/user")
@Api(value = "/UserController", tags = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/greet")
    public String greet() {
        return "Hello World";
    }

    @ResponseBody
    @PostMapping("/add")
    public int addUser(User user) {
        return userService.addUser(user);
    }

    @ResponseBody
    @ApiOperation(value = "查询所有用户", notes = "查询所有用户")
    @RequestMapping(value = "/queryAllUsers", method = {RequestMethod.POST, RequestMethod.GET})
    public List<User> queryAllUsers() {
        return userService.queryAllUsers();
    }


    @ResponseBody
    @RequestMapping(value = "/queryUsersByName", method = RequestMethod.POST)
    public List<User> queryUsersByName(@RequestBody List<String> names) {
        return userService.queryUsersByName(names);
    }

//    @ResponseBody
//    @ApiOperation(value = "查询用户指定字段", notes = "查询所有用户")
//    @RequestMapping(value = "/querySthUsersByName", method = RequestMethod.POST)
//    public List<User> querySthUsersByName(@RequestBody QueryVo queryVo) {
//        log.info("method:{}, param:{}", "querySthUsersByName", queryVo);
//        return userService.querySthUsersByName(queryVo);
//    }

}