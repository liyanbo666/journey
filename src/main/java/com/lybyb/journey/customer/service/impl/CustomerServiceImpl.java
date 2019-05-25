package com.lybyb.journey.customer.service.impl;

import com.lybyb.journey.customer.dao.CustomerMapper;
import com.lybyb.journey.customer.model.Customer;
import com.lybyb.journey.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: bunuo
 * @Date: 2019/4/27 13:51
 * @Description:
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public Map<String, Object> getCustomerList(Customer customer) {
        Map<String,Object>returnMap=new HashMap<>();
        try{
           List<Customer> customerList= customerMapper.getCustomerList(customer);
            returnMap.put("code","200");
            returnMap.put("data",customerList);
            returnMap.put("msg","客户信息获取成功");
        }catch (Exception e){
            e.printStackTrace();
            returnMap.put("code","000");
            returnMap.put("msg","客户信息获取失败");
        }
        return returnMap;
    }

    @Override
    public Map<String, Object> getCustomerById(Long id) {
        Map<String,Object>returnMap=new HashMap<>();
        try{
            Customer customer= customerMapper.getCustomerById(id);
            returnMap.put("code","200");
            returnMap.put("data",customer);
            returnMap.put("msg","客户信息详情获取成功");
        }catch (Exception e){
            e.printStackTrace();
            returnMap.put("code","000");
            returnMap.put("msg","客户信息详情获取失败");
        }
        return returnMap;
    }


    @Override
    public Map<String, Object> saveOrUpdateCustomer(Customer customer) {
        Map<String,Object>returnMap=new HashMap<>();
        try{
            if(customer.getId()!=null){
                customerMapper.modifyCustomer(customer);
            }else{
                customerMapper.saveCustomer(customer);
            }


            returnMap.put("code","200");
            returnMap.put("msg","客户信息保存成功");
        }catch (Exception e){
            e.printStackTrace();
            returnMap.put("code","000");
            returnMap.put("msg","客户信息保存失败");
        }
        return returnMap;
}
    @Override
    public Map<String, Object> deleteCustomer(Long id) {
        Map<String,Object>returnMap=new HashMap<>();
        try{
            customerMapper.deleteCustomer(id);
            returnMap.put("code","200");
            returnMap.put("msg","客户信息删除成功");
        }catch (Exception e){
            e.printStackTrace();
            returnMap.put("code","000");
            returnMap.put("msg","客户信息删除失败");
        }
        return returnMap;
    }
}
