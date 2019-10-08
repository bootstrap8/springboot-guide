package com.fit.h2.user.repository;

import com.fit.h2.user.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-10-07
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
