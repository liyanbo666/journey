package com.lybyb.journey.order.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.lybyb.journey.config.CustomJsonDateDeserializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: bunuo
 * @Date: 2019/4/14 10:30
 * @Description:
 */
@Data
public class Order implements Serializable{

    private Long id;
    /**
     * 客户姓名
     *
     * @Description
     * @Param
     * @Return
     * @Author liyanbo
     * @Date 2019/4/14 17:15
     */
    private String name;
    /**
     * 客户电话号码
     *
     * @Description
     * @Param
     * @Return
     * @Author liyanbo
     * @Date 2019/4/14 17:15
     */
    private String phone;
    /**
     * 微信号
     *
     * @Description
     * @Param
     * @Return
     * @Author liyanbo
     * @Date 2019/4/14 18:32
     */
    private String customerWX;
    /**
     * 是否已加微信
     *
     * @Description
     * @Param
     * @Return
     * @Author liyanbo
     * @Date 2019/4/14 17:15
     */
    private String existWX;
    /**
     * 咨询日期
     *
     * @Description
     * @Param
     * @Return
     * @Author liyanbo
     * @Date 2019/4/14 17:15
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date consultTime;
    /**
     * 咨询计划
     *
     * @Description
     * @Param
     * @Return
     * @Author liyanbo
     * @Date 2019/4/14 17:15
     */
    private String followUpPlan;
    /**
     * 咨询过程
     *
     * @Description
     * @Param
     * @Return
     * @Author liyanbo
     * @Date 2019/4/14 17:15
     */
    private String followUpProcess;
    /**
     * 订单来源
     *
     * @Description
     * @Param
     * @Return
     * @Author liyanbo
     * @Date 2019/4/14 17:15
     */
    private String origin;
    /**
     * 备注
     *
     * @Description
     * @Param
     * @Return
     * @Author liyanbo
     * @Date 2019/4/14 17:15
     */
    private String remark;
    /**
     * 下一次咨询日期
     *
     * @Description
     * @Param
     * @Return
     * @Author liyanbo
     * @Date 2019/4/14 17:15
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date nextConsultTime;
    /**
     * 咨询/推荐课程
     *
     * @Description
     * @Param
     * @Return
     * @Author liyanbo
     * @Date 2019/4/14 17:15
     */
    private String course;
    /**
     * 创建时间
     *
     * @Description
     * @Param
     * @Return
     * @Author liyanbo
     * @Date 2019/4/14 17:15
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date createTime;
    /**
     * 创建人
     *
     * @Description
     * @Param
     * @Return
     * @Author liyanbo
     * @Date 2019/4/14 17:15
     */
    private String createUser;
    /**
     * 修改人
     *
     * @Description
     * @Param
     * @Return
     * @Author liyanbo
     * @Date 2019/4/14 17:15
     */
    private String modifyUser;
    /**
     * 修改时间
     *
     * @Description
     * @Param
     * @Return
     * @Author liyanbo
     * @Date 2019/4/14 17:15
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date modifyTime;

    private Long courseId;
    private Long existWXId;
    private Long customerId;
    private String status;
    private Long labelId;
    private String labelValue;
    private String idCard;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date nextConsultBeginTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date nextConsultEndTime;

}
