package com.fit.user.dao;

import com.fit.user.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-10-07
 */
public interface UserDao {

    int insert(UserEntity user);

    List<UserEntity> queryAllUsers();

    List<UserEntity> queryUsersByName(List<String> names);

    List<UserEntity> querySthUsersByName(@Param("columns") String columns, @Param("names") List<String> names);

    List<UserEntity> queryUsersByMap(Map map);

    Long queryMaxUserId();

    /**
     * 动态根据表名插入，适用于月表
     *
     * @param table
     * @param users
     * @return
     */
    int insertUsersByTable(@Param("table") String table, @Param("users") List<UserEntity> users);

    boolean ifTableExist(@Param("tableName") String tableName);

    void createMonitorTable();

    void createMonitorThresholdTable();

}
