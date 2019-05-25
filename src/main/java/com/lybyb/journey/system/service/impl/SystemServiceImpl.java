package com.lybyb.journey.system.service.impl;

import com.lybyb.journey.system.dao.UserRepository;
import com.lybyb.journey.system.model.SysDict;
import com.lybyb.journey.system.model.User;
import com.lybyb.journey.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class SystemServiceImpl implements SystemService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HttpSession session;

    @Override
    public Map<String, Object> login(User user) {
        Map<String, Object> returnMap = new HashMap<>();
        User loginUser = userRepository.findByUsername(user.getUsername());
        if (loginUser != null) {
            session.setAttribute("user", loginUser);
            if (user.getUsername().equals(loginUser.getUsername())) {
                returnMap.put("code", "200");
                returnMap.put("msg", "登录成功");
            }
        } else {
            returnMap.put("code", "000");
            returnMap.put("msg", "登录失败，用户名或密码");
        }
        return returnMap;
    }

    @Override
    public Map<String, Object> findSysDict(String type) {
        Map<String, Object> returnMap = new HashMap<>();
        List<SysDict>sysDictList= userRepository.findSysDict(type);
        returnMap.put("data",sysDictList);
        return returnMap;
    }

    @Override
    public Map<String, Object> findCourseSelectList() {
        Map<String, Object> returnMap = new HashMap<>();
        List<SysDict>sysDictList= userRepository.findCourseSelectList();
        returnMap.put("data",sysDictList);
        return returnMap;
    }
}
