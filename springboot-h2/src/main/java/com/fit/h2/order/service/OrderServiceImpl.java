package com.fit.h2.order.service;

import com.fit.h2.order.dao.OrderDao;
import com.fit.h2.order.dao.entity.OrderEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

//    @Override
//    public List<OrderEntity> queryAllOrders() {
//
//        return orderDao.queryAllOrders();
//    }

    @Override
    public List<OrderEntity> queryAllOrders() {

        List<OrderEntity> entityList = new ArrayList<>();

        sqlSessionTemplate.select("com.fit.h2.order.dao.OrderDao.queryAllOrders", new ResultHandler() {
            @Override
            public void handleResult(ResultContext resultContext) {
                //do sth...
                entityList.add(OrderEntity.class.cast(resultContext.getResultObject()));
            }
        });

        return entityList;
    }
}
