package com.fit.h2.order;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-12-12
 */
@Slf4j
public class OrderImpl implements Order {

    public OrderImpl(){
        log.info("create order by spring.factory");
        System.out.println("create order by spring.factory");
    }
}
