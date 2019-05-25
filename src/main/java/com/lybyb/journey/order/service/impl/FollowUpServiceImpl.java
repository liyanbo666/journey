package com.lybyb.journey.order.service.impl;

import com.lybyb.journey.order.dao.FollowUpMapper;
import com.lybyb.journey.order.model.FollowUpRecord;
import com.lybyb.journey.order.model.Order;
import com.lybyb.journey.order.service.FollowUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: bunuo
 * @Date: 2019/5/2 15:43
 * @Description:
 */
@Service
public class FollowUpServiceImpl implements FollowUpService {
    @Autowired
    private FollowUpMapper followUpMapper;
    @Override
    public Map<String, Object> findFollowUpRecordList(Long id) {
        Map<String,Object> returnMap=new HashMap<>();
        try{

            List<FollowUpRecord> followUpRecordList=followUpMapper.findFollowUpRecordList(id);
            returnMap.put("data",followUpRecordList);
            returnMap.put("code", "200");
            returnMap.put("msg", "跟进记录列表获取成功");
        }catch (Exception e){
            e.printStackTrace();
            returnMap.put("code", "000");
            returnMap.put("msg", "跟进记录列表获取失败");
        }
        return returnMap;
    }

    @Override
    public Map<String, Object> updateFollowUpRecord(FollowUpRecord followUpRecord) {
        Map<String,Object> returnMap=new HashMap<>();
        try{

            followUpMapper.updateFollowUpRecord(followUpRecord);
            returnMap.put("code", "200");
            returnMap.put("msg", "跟进记录列表获取成功");
        }catch (Exception e){
            e.printStackTrace();
            returnMap.put("code", "000");
            returnMap.put("msg", "跟进记录列表获取失败");
        }
        return returnMap;
    }

    @Override
    public Map<String, Object> deleteFollowUpRecord(Long id) {
        Map<String,Object> returnMap=new HashMap<>();
        try{

            followUpMapper.deleteFollowUpRecord(id);
            returnMap.put("code", "200");
            returnMap.put("msg", "跟进记录列表获取成功");
        }catch (Exception e){
            e.printStackTrace();
            returnMap.put("code", "000");
            returnMap.put("msg", "跟进记录列表获取失败");
        }
        return returnMap;
    }

    @Override
    public Map<String, Object> saveFollowUpRecord(FollowUpRecord followUpRecord) {
        Map<String,Object> returnMap=new HashMap<>();
        try{

            followUpMapper.saveFollowUpRecord(followUpRecord);
            returnMap.put("code", "200");
            returnMap.put("msg", "跟进记录列表获取成功");
        }catch (Exception e){
            e.printStackTrace();
            returnMap.put("code", "000");
            returnMap.put("msg", "跟进记录列表获取失败");
        }
        return returnMap;
    }
}
