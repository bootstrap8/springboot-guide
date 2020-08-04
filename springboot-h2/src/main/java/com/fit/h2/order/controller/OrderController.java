package com.fit.h2.order.controller;

import com.alibaba.fastjson.JSON;
import com.fit.common.response.ResponseVo;
import com.fit.h2.order.controller.vo.QueryVo;
import com.fit.h2.order.service.OrderService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/isTableExist", method = {RequestMethod.POST})
    public ResponseVo isTableExist(@RequestParam("tableName") String name) {
        return ResponseVo.okFrom(orderService.isTableExist(name));
    }

    @RequestMapping(value = "/queryAllOrders", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseVo queryAllOrders() {
        return ResponseVo.okFrom(orderService.queryAllOrders());
    }

    /**
     * GET不支持@RequestBody
     *
     * @param queryVo
     * @return
     */
    @RequestMapping(value = "/queryAllOrdersByVo", method = {RequestMethod.POST})
    public ResponseVo queryOrders(@RequestBody QueryVo queryVo) {
        log.info("queryVo : {}", JSON.toJSONString(queryVo));
        return ResponseVo.okFrom(queryVo.getName());
    }


}
