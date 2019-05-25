package com.lybyb.journey.customer.controller;

import com.lybyb.journey.customer.model.Customer;
import com.lybyb.journey.customer.service.CustomerService;
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
 * @Date: 2019/4/27 13:45
 * @Description:
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @RequestMapping(value = "/getCustomerList",method = RequestMethod.POST)
    public void getCustomerList(@RequestBody Customer customer, HttpServletRequest request, HttpServletResponse response){
        PrintWriter writer = null;
        try {
            response.setCharacterEncoding("UTF-8");
            writer = response.getWriter();
            Map<String, Object> returnMap = customerService.getCustomerList(customer);
            writer.write(JsonUtil.map2json(returnMap));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }
    @RequestMapping(value = "/getCustomerById",method = RequestMethod.POST)
    public void getCustomerById(HttpServletRequest request, HttpServletResponse response){
        PrintWriter writer = null;
        try {
            response.setCharacterEncoding("UTF-8");
            writer = response.getWriter();
            Long id=Long.parseLong(request.getParameter("id"));
            Map<String, Object> returnMap = customerService.getCustomerById(id);
            writer.write(JsonUtil.map2json(returnMap));
            System.out.println(JsonUtil.map2json(returnMap));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }
    @RequestMapping(value = "/saveOrUpdateCustomer",method = RequestMethod.POST)
    public void saveOrUpdateCustomer(@RequestBody Customer customer, HttpServletRequest request, HttpServletResponse response){
        PrintWriter writer = null;
        try {
            response.setCharacterEncoding("UTF-8");
            writer = response.getWriter();
            Map<String, Object> returnMap = customerService.saveOrUpdateCustomer(customer);
            writer.write(JsonUtil.map2json(returnMap));
            System.out.println(JsonUtil.map2json(returnMap));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }
    @RequestMapping(value = "/deleteCustomer",method = RequestMethod.POST)
    public void deleteCustomer(HttpServletRequest request, HttpServletResponse response){
        PrintWriter writer = null;
        try {
            response.setCharacterEncoding("UTF-8");
            writer = response.getWriter();
            Long id=Long.parseLong(request.getParameter("id"));
            Map<String, Object> returnMap = customerService.deleteCustomer(id);
            writer.write(JsonUtil.map2json(returnMap));
            System.out.println(JsonUtil.map2json(returnMap));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }
}
