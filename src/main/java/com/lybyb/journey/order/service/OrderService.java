package com.lybyb.journey.order.service;

import com.lybyb.journey.order.model.Order;

import java.util.Map;

/**
 * @Auther: bunuo
 * @Date: 2019/4/14 10:29
 * @Description:
 */
public interface OrderService {
    Map<String, Object> getOrderList(Order order);
    Map<String, Object> saveOrUpdateOrder(Order order);
    Map<String, Object> getOrderListById(Long id);
    Map<String, Object>  deleteOrder(Long id);
    Map<String,Object> dealOrder(Long id);
}
