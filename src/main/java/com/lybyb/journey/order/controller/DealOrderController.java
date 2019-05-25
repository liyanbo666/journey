package com.lybyb.journey.order.controller;

import com.lybyb.journey.order.model.DealOrder;
import com.lybyb.journey.order.service.DealOrderService;
import com.lybyb.journey.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @Auther: bunuo
 * @Date: 2019/5/1 23:32
 * @Description:
 */
@Controller
@RequestMapping("/dealOrder")
public class DealOrderController {
    @Autowired
    private DealOrderService dealOrderService;
    @RequestMapping(value = "/getDealOrderList",method = RequestMethod.POST)
    public void getDealOrderList(@RequestBody DealOrder dealOrder,HttpServletRequest request, HttpServletResponse response){
        PrintWriter writer = null;
        try {
            response.setCharacterEncoding("UTF-8");
            writer = response.getWriter();
            Map<String, Object> returnMap = dealOrderService.getDealOrderList(dealOrder);
            writer.write(JsonUtil.map2json(returnMap));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }
    @RequestMapping(value = "/createDealOrder",method = RequestMethod.POST)
    public void createDealOrder(HttpServletRequest request, HttpServletResponse response){
        PrintWriter writer = null;
        try {
            response.setCharacterEncoding("UTF-8");
            writer = response.getWriter();
            Long id=Long.parseLong(request.getParameter("applyOrderId"));
            Map<String, Object> returnMap = dealOrderService.createDealOrder(id);
            writer.write(JsonUtil.map2json(returnMap));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }
    @RequestMapping(value = "/getDealOrderListById",method = RequestMethod.POST)
    public void getDealOrderListById(HttpServletRequest request, HttpServletResponse response){
        PrintWriter writer = null;
        try {
            response.setCharacterEncoding("UTF-8");
            writer = response.getWriter();
            Long id=Long.parseLong(request.getParameter("id"));
            Map<String, Object> returnMap = dealOrderService.getDealOrderListById(id);
            writer.write(JsonUtil.map2json(returnMap));
            System.out.println(JsonUtil.map2json(returnMap));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }

    @RequestMapping(value = "/deleteDealOrder",method = RequestMethod.POST)
    public void deleteDealOrder(HttpServletRequest request, HttpServletResponse response){
        PrintWriter writer = null;
        try {
            response.setCharacterEncoding("UTF-8");
            writer = response.getWriter();
            Long id=Long.parseLong(request.getParameter("id"));
            Map<String, Object> returnMap = dealOrderService.deleteDealOrder(id);
            writer.write(JsonUtil.map2json(returnMap));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }
    @RequestMapping(value = "/updateDealOrder",method = RequestMethod.POST)
    public void updateDealOrder(@RequestBody DealOrder dealOrder,HttpServletRequest request, HttpServletResponse response){
        PrintWriter writer = null;
        try {
            response.setCharacterEncoding("UTF-8");
            writer = response.getWriter();
            Map<String, Object> returnMap = dealOrderService.updateDealOrder(dealOrder);
            writer.write(JsonUtil.map2json(returnMap));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }
}
