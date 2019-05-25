package com.lybyb.journey.order.controller;

import com.lybyb.journey.order.model.Order;
import com.lybyb.journey.order.service.OrderService;
import com.lybyb.journey.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @Auther: bunuo
 * @Date: 2019/4/14 10:29
 * @Description:
 */
@RestController(value = "/orderApply")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping(value = "/getOrderList",method = RequestMethod.POST)
    public void getOrderList(@RequestBody Order order, HttpServletRequest request, HttpServletResponse response){
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            Map<String, Object> returnMap = orderService.getOrderList(order);
            writer.write(JsonUtil.map2json(returnMap));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }
}
