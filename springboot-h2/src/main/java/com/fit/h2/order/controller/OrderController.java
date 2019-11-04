package com.fit.h2.order.controller;

import com.fit.h2.order.service.OrderService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-11-01
 */
@Slf4j
@RestController
@Api(value = "订单管理", description = "OrderController")
public class OrderController {

    @Autowired
    private OrderService orderService;

}
