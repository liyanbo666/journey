package com.lybyb.journey.order.service.impl;

import com.lybyb.journey.order.dao.OrderMapper;
import com.lybyb.journey.order.model.Order;
import com.lybyb.journey.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Auther: bunuo
 * @Date: 2019/4/14 17:28
 * @Description:
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public Map<String, Object> getOrderList(Order order) {
        Map<String,Object> returnMap=new HashMap<>();
        try{

            List<Order> orderList=orderMapper.getOrderList(order);

            Collections.sort(orderList, Comparator.comparing(Order::getTimeFromNow));
            returnMap.put("data",orderList);
            returnMap.put("code", "200");
            returnMap.put("msg", "订单列表获取成功");
        }catch (Exception e){
            e.printStackTrace();
            returnMap.put("code", "000");
            returnMap.put("msg", "订单列表获取失败");
        }
        return returnMap;
    }

    @Override
    public Map<String, Object> saveOrUpdateOrder(Order order) {
        Map<String,Object> returnMap=new HashMap<>();
        if(order!=null){
            if(order.getId()==null){
                orderMapper.saveOrder(order);
                returnMap.put("code", "200");
                returnMap.put("msg", "订单新增成功");
            }else{
                orderMapper.updateOrder(order);
                returnMap.put("code", "200");
                returnMap.put("msg", "订单修改成功");
            }
        }else{
            returnMap.put("code", "000");
            returnMap.put("msg", "订单操作失败");
        }
        return returnMap;
    }

    @Override
    public Map<String, Object> getOrderListById(Long id) {
        Map<String,Object> returnMap=new HashMap<>();
        try{

            Order order=orderMapper.getOrderListById(id);
            returnMap.put("data",order);
            returnMap.put("code", "200");
            returnMap.put("msg", "订单列表获取成功");
        }catch (Exception e){
            e.printStackTrace();
            returnMap.put("code", "000");
            returnMap.put("msg", "订单列表获取失败");
        }
        return returnMap;
    }

    @Override
    public Map<String, Object>  deleteOrder(Long id) {
        Map<String,Object> returnMap=new HashMap<>();
        try{
            orderMapper.deleteOrder(id);
            returnMap.put("code", "200");
            returnMap.put("msg", "订单列表获取成功");
        }catch (Exception e){
            e.printStackTrace();
            returnMap.put("code", "000");
            returnMap.put("msg", "订单列表获取失败");
        }
        return returnMap;
    }

    @Override
    public Map<String, Object> dealOrder(Long id) {
        Map<String,Object> returnMap=new HashMap<>();
        try{
            orderMapper.dealOrder(id);
            returnMap.put("code", "200");
            returnMap.put("msg", "订单成单成功");
        }catch (Exception e){
            e.printStackTrace();
            returnMap.put("code", "000");
            returnMap.put("msg", "订单成单失败");
        }
        return returnMap;
    }
    private boolean isToday(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String param = sdf.format(date);//参数时间
        String now = sdf.format(new Date());//当前时间
        if(param.equals(now)){
            return true;
        }
        return false;
    }

}
