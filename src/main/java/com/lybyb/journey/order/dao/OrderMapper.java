package com.lybyb.journey.order.dao;

import com.lybyb.journey.order.model.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Auther: bunuo
 * @Date: 2019/4/14 10:30
 * @Description:
 */
@Mapper
public interface OrderMapper {
    List<Order> getOrderList(Order order);
    Order getOrderListById(@Param("id") Long id);

    void saveOrder(Order order);
    void updateOrder(Order order);
    @Delete("delete from apply_order where id=#{id}")
    void deleteOrder(Long id);
    @Update("update apply_order set status='1' where id=#{id}")
    void dealOrder(Long id);
}
