package com.lybyb.journey.order.service;

import com.lybyb.journey.order.model.DealOrder;

import java.util.Map;

public interface DealOrderService {
    Map<String, Object> createDealOrder(Long applyOrderId);

    Map<String, Object> getDealOrderList(DealOrder dealOrder);

    Map<String, Object> getDealOrderListById(Long id);

    Map<String, Object> deleteDealOrder(Long id);

    Map<String, Object> updateDealOrder(DealOrder dealOrder);
}
