package com.fit.h2.order.dao;

import com.fit.h2.order.dao.entity.OrderEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-11-04
 */
@Repository
public interface OrderDao {
    List<OrderEntity> queryAllOrders();
}
