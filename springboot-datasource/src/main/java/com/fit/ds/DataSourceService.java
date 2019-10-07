package com.fit.ds;

import com.fit.common.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-09-16
 */
@Slf4j
@Service
public class DataSourceService {

    @Resource
    private JdbcTemplate primaryJdbcTemplate;

    @Resource
    private JdbcTemplate historyJdbcTemplate;

    public void save() {
        try {
            String birthday = DateUtil.format(new Date());
            int maxId = primaryJdbcTemplate.queryForObject("select max(id) from tab_user", Integer.class);
            String sql = "insert into tab_user(id, name, age, address, birthday) values(" + (maxId + 1) + ",'Tomcat','20','primaryJdbcTemplate',to_date('" + birthday + "','yyyy-mm-dd'))";
            log.info("-->primary : {}", sql);
            primaryJdbcTemplate.update(sql);
            maxId = historyJdbcTemplate.queryForObject("select max(id) from tab_user", Integer.class);
            sql = "insert into tab_user(id, name, age, address,birthday) values(" + (maxId + 1) + ",'Jetty','20','historyJdbcTemplate',to_date('" + birthday + "','yyyy-mm-dd'))";
            log.info("-->history : {}", sql);
            historyJdbcTemplate.update(sql);
        } catch (Exception e) {
            log.error("", e);
        }
    }
}
