package com.fit.jpa.user.repository;

import com.fit.jpa.user.repository.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-10-07
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void addUser() {
        UserEntity user = new UserEntity();
        user.setId(100);
        user.setName("Mark");
        user.setAddress("BJ");
        userRepository.save(user);

        Optional<UserEntity> optionalUser = userRepository.findById(1);

        log.info("query user : {}", optionalUser.get());
    }
}