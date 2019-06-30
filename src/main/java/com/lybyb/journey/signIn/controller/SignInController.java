package com.lybyb.journey.signIn.controller;

import com.lybyb.journey.signIn.model.SignIn;
import com.lybyb.journey.util.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author admin
 * @description
 * @date 19:19
 */
@Controller
@RequestMapping(value = "/signId")
public class SignInController {
    @RequestMapping(value = "/findSignInList",method = RequestMethod.POST)
    public void findSignInList(@RequestBody SignIn signIn, HttpServletRequest request, HttpServletResponse response){
        PrintWriter writer = null;
        try {
            response.setCharacterEncoding("UTF-8");
            writer = response.getWriter();
            Map<String, Object> returnMap = customerService.getSignInList(signIn);
            writer.write(JsonUtil.map2json(returnMap));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }
}
