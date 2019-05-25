package com.lybyb.journey.order.dao;

import com.lybyb.journey.order.model.DealOrder;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;
@Mapper
public interface DealOrderMapper {
    @Insert("INSERT into deal_order (apply_order_id,create_time)VALUE (#{applyOrderId},now())")
    void createDealOrder(Long applyOrderId);
    List<DealOrder> getDealOrderList(DealOrder dealOrder);

    DealOrder getDealOrderListById(Long id);
    @Delete("delete from deal_order where id=#{id}")
    void deleteDealOrder(Long id);
    void updateDealOrder(DealOrder dealOrder);
    @Update("update apply_order set status='1' where id =#{id}")
    void updateOrderStatus(Long id);
}
