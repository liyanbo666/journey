package com.lybyb.journey.system.service;

import com.lybyb.journey.system.model.User;
import java.util.Map;

/**
 * @author liaynbo
 * 系统服务层
 */
public interface SystemService {
    Map<String, Object> login(User user);
    Map<String,Object> findSysDict(String type);
    Map<String,Object> findCourseSelectList();
}
