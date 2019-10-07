package com.fit.user.service;

import com.fit.user.dao.UserDao;
import com.fit.user.dao.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-10-07
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(User user) {
        return userDao.insert(user);
    }

    @Override
    public List<User> queryAllUsers() {
        return userDao.queryAllUsers();
    }

    @Override
    public List<User> queryUsersByName(List<String> names) {
        return userDao.queryUsersByName(names);
    }

//    @Override
//    public List<User> querySthUsersByName(QueryVo queryVo) {
//        return userDao.querySthUsersByName(queryVo.getColumns(), queryVo.getNames());
//    }

    @Override
    public List<User> queryUsersByMap(Map map) {
        log.info("queryUsersByMap params : {}", map);
        return userDao.queryUsersByMap(map);
    }

    @Override
    public long queryMaxUserId() {
        return userDao.queryMaxUserId();
    }

    @Override
    public int insertUsersByTable(String table, List<User> users) {
        return userDao.insertUsersByTable(table, users);
    }

//    public void query(){
//        PageHelper.startPage(catalogQueryInfo.getPageNo(), catalogQueryInfo.getPageSize(), "template_id desc");
//        List<NsstEntity> nsstEntities = catalogDao.queryNsstByCatalog(catalogQueryInfo);
//        PageInfo<NsstEntity> page = new PageInfo<>(nsstEntities);
//        //返回结果集
//        PageVo pageVo = new PageVo(page.getTotal(), page.getList());
//    }
}
