package com.lybyb.journey.customer.model;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: bunuo
 * @Date: 2019/4/27 13:46
 * @Description:
 */
@Data
public class Customer {
    private Long id;
    private String  name;
    private String phone;
    private String idCard;
    private String address;
    private String customerWXNum;
    private long origin;
    private String originValue;
    private Date createTime;
    private Date modifyTime;
}
