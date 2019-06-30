package com.lybyb.journey.signIn.model;

import lombok.Data;

import java.util.Date;

/**
 * @author admin
 * @description
 * @date 19:16
 */
@Data
public class SignIn {
    private Long id;
    private Long customerId;
    private Long courseId;
    private Date createTime;
    private Date updateTime;
    private String createUser;
    private String updateUser;

}
