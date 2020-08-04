package com.fit.h2.order.service;

import com.fit.h2.order.dao.entity.OrderEntity;

import java.util.List;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-11-01
 */
public interface OrderService {

    boolean isTableExist(String tableName);

    List<OrderEntity> queryAllOrders();
}
