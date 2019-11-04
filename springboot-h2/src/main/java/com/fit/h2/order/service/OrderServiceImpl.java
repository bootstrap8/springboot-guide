package com.fit.h2.order.service;

import com.fit.h2.order.dao.OrderDao;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-11-01
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

}
