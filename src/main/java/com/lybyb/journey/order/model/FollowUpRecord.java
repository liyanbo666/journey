package com.lybyb.journey.order.model;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: bunuo
 * @Date: 2019/5/2 15:29
 * @Description:
 */
@Data
public class FollowUpRecord {
    private Long id;
    private Long applyOrderId;
    private String followUpPlan;
    private String followUpProcess;
    private Date createTime;
    private Date modifyTime;
}
