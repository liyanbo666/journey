package com.lybyb.journey.order.service.impl;

import com.lybyb.journey.order.dao.DealOrderMapper;
import com.lybyb.journey.order.dao.OrderMapper;
import com.lybyb.journey.order.model.DealOrder;
import com.lybyb.journey.order.model.Order;
import com.lybyb.journey.order.service.DealOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: bunuo
 * @Date: 2019/5/1 23:45
 * @Description:
 */
@Service
public class DealOrderServiceIml implements DealOrderService{
    @Autowired
    private DealOrderMapper dealOrderMapper;
private OrderMapper orderMapper;
    @Override
    public Map<String, Object> createDealOrder(Long applyOrderId) {
        Map<String,Object> returnMap=new HashMap<>();
        try{
            dealOrderMapper.updateOrderStatus(applyOrderId);
            dealOrderMapper.createDealOrder(applyOrderId);
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
    public Map<String, Object> getDealOrderList(DealOrder dealOrder) {
        Map<String,Object> returnMap=new HashMap<>();
        try{

            List<DealOrder> dealOrderList=dealOrderMapper.getDealOrderList(dealOrder);
            returnMap.put("data",dealOrderList);
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
    public Map<String, Object> getDealOrderListById(Long id) {
        Map<String,Object> returnMap=new HashMap<>();
        try{
            DealOrder dealOrder=dealOrderMapper.getDealOrderListById(id);
            returnMap.put("data",dealOrder);
            returnMap.put("code", "200");
            returnMap.put("msg", "成单详情获取成功");
        }catch (Exception e){
            e.printStackTrace();
            returnMap.put("code", "000");
            returnMap.put("msg", "成单详情获取失败");
        }
        return returnMap;
    }

    @Override
    public Map<String, Object> deleteDealOrder(Long id) {
        Map<String,Object> returnMap=new HashMap<>();
        try{

            dealOrderMapper.deleteDealOrder(id);
            returnMap.put("code", "200");
            returnMap.put("msg", "成单数据删除成功");
        }catch (Exception e){
            e.printStackTrace();
            returnMap.put("code", "000");
            returnMap.put("msg", "成单数据删除失败");
        }
        return returnMap;
    }

    @Override
    public Map<String, Object> updateDealOrder(DealOrder dealOrder) {
        Map<String,Object> returnMap=new HashMap<>();
        try{
            dealOrderMapper.updateDealOrder(dealOrder);
            returnMap.put("code", "200");
            returnMap.put("msg", "成单数据更新成功");
        }catch (Exception e){
            e.printStackTrace();
            returnMap.put("code", "000");
            returnMap.put("msg", "成单数据更新失败");
        }
        return returnMap;
    }
}
