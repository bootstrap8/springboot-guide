package com.fit.order.dao;

import com.fit.user.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-10-07
 */
//@Mapper
public interface OrderDao {

    @Select({"select * from tab_user"})
    List<UserEntity> queryUsers();
}
