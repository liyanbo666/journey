package com.lybyb.journey.customer.service;

import com.lybyb.journey.customer.model.Customer;

import java.util.Map;

public interface CustomerService {
    Map<String,Object> getCustomerList(Customer customer);
    Map<String,Object> getCustomerById(Long id);
    Map<String,Object> saveOrUpdateCustomer(Customer customer);
    Map<String,Object> deleteCustomer(Long id);
}
