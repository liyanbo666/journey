package com.lybyb.journey.order.service;

import com.lybyb.journey.order.model.FollowUpRecord;

import java.util.Map;

/**
 * @Auther: bunuo
 * @Date: 2019/5/2 15:38
 * @Description:
 */
public interface FollowUpService {
    Map<String,Object> findFollowUpRecordList(Long id);
    Map<String,Object> updateFollowUpRecord(FollowUpRecord followUpRecord);
    Map<String,Object> deleteFollowUpRecord(Long id);
    Map<String,Object> saveFollowUpRecord(FollowUpRecord followUpRecord);
}
