package com.fit.service;

import com.fit.bean.User;
import com.fit.springbootguide.SpringbootGuideApplication;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-09-26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootGuideApplication.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void insertUsersByTable() {
        String table = "tab_user";
        List<User> users = Lists.newArrayList();
        Long maxId = userService.queryMaxUserId();
        User user = new User();
        user.setId(maxId + 1);
        user.setName("Test");
        user.setAge(20);
        user.setAddress("NJ");
        user.setBirthday(new Date());
        users.add(user);
        int count = userService.insertUsersByTable(table, users);
        System.out.println("insert Count : " + count);
    }
}