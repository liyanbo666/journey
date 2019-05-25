package com.lybyb.journey.order.controller;

import com.lybyb.journey.order.model.FollowUpRecord;
import com.lybyb.journey.order.service.FollowUpService;
import com.lybyb.journey.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @Auther: bunuo
 * @Date: 2019/5/2 15:37
 * @Description:
 */
@Controller
@RequestMapping("/followUpRecord")
public class FollowUpController {
    @Autowired
    private FollowUpService followUpService;
    @RequestMapping(value = "/findFollowUpRecordList",method = RequestMethod.POST)
    public void findFollowUpRecordList(HttpServletRequest request, HttpServletResponse response){
        PrintWriter writer = null;
        try {
            response.setCharacterEncoding("UTF-8");
            writer = response.getWriter();
            Long id=Long.parseLong(request.getParameter("id"));
            Map<String, Object> returnMap = followUpService.findFollowUpRecordList(id);
            writer.write(JsonUtil.map2json(returnMap));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }
    @RequestMapping(value = "/deleteFollowUpRecord",method = RequestMethod.POST)
    public void deleteFollowUpRecord(HttpServletRequest request, HttpServletResponse response){
        PrintWriter writer = null;
        try {
            response.setCharacterEncoding("UTF-8");
            writer = response.getWriter();
            Long id=Long.parseLong(request.getParameter("id"));
            Map<String, Object> returnMap = followUpService.deleteFollowUpRecord(id);
            writer.write(JsonUtil.map2json(returnMap));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }
    @RequestMapping(value = "/updateFollowUpRecord",method = RequestMethod.POST)
    public void getOrderList(@RequestBody FollowUpRecord followUpRecord, HttpServletRequest request, HttpServletResponse response){
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            Map<String, Object> returnMap = followUpService.updateFollowUpRecord(followUpRecord);
            writer.write(JsonUtil.map2json(returnMap));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }
    @RequestMapping(value = "/saveFollowUpRecord",method = RequestMethod.POST)
    public void saveFollowUpRecord(@RequestBody FollowUpRecord followUpRecord, HttpServletRequest request, HttpServletResponse response){
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            Map<String, Object> returnMap = followUpService.saveFollowUpRecord(followUpRecord);
            writer.write(JsonUtil.map2json(returnMap));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }
}
