package com.lybyb.journey.order.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.lybyb.journey.config.CustomJsonDateDeserializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Auther: bunuo
 * @Date: 2019/5/1 23:35
 * @Description:
 */
@Data
public class DealOrder extends Order {
    private Long id;
    private Long applyOrderId;
    private Date dealOrderTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date workDate;
    private String dealOrderProcess;
    private String dealSchool;
    private String dealBelonger;
    private String payType;
    private String payTypeValue;
    private Double amount;
    private String agreementStatus;
    private String dealOrderCycle;
    private String agreementStatusValue;
    private String other;
    private Long courseId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date modifyTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date createBeginTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date createEndTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date workBeginTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date workEndTime;
    private String workCourse;
}
