package com.lybyb.journey.customer.dao;

import com.lybyb.journey.customer.model.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerMapper {
    List<Customer> getCustomerList(Customer customer);
    Customer getCustomerById(@Param("id") Long id);
    void modifyCustomer(Customer customer);
    void saveCustomer(Customer customer);
    void deleteCustomer(Long id);
}
