package com.lybyb.journey.system.controller;

import com.lybyb.journey.system.model.User;
import com.lybyb.journey.system.service.SystemService;
import com.lybyb.journey.util.JsonUtil;
import com.lybyb.journey.util.UUIDUtil;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author liyanbo
 */
@Controller
@RequestMapping(value = "/system")
public class SystemController {
    @Autowired
    private SystemService systemService;
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public void doLogin(@RequestBody(required = false) User user, HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getParameter("username") + "开始登陆");
        PrintWriter writer=null;
        try {
            writer=response.getWriter();
            Map<String, Object> returnMap = systemService.login(user);
            writer.write(JsonUtil.map2json(returnMap));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            writer.flush();
            writer.close();
        }
    }


    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error() {
        return "error";
    }

    @RequestMapping(value = "/home")
    public String home() {
        return "/home";
    }

    @RequestMapping(value = "/getImgCode", method = RequestMethod.GET)
    @ResponseBody
    public Object getImgCode(HttpServletResponse response) throws IOException {

        //在此处 设置JSP页面无缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        Random random = new Random();
        // 定义数组存放加减乘除四个运算符
        //加减乘
        String[] arr_chi = {"\u52a0", "\u51cf", "\u4e58"};
        // 生成10以内的随机整数num1
        int num1 = random.nextInt(10);
        // 生成一个0-4之间的随机整数operate
        int operate = random.nextInt(3);
        // 生成10以内的随机整数num1
        int num2 = random.nextInt(10);
        int width = 60, height = 20;
        //创建BufferedImage对象，设置图片的长度宽度和色彩。
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //取得Graphics对象，用来绘制图片
        Graphics g = image.getGraphics();
        //绘制图片背景和文字,释放Graphics对象所占用的资源。
        g.setColor(getRandColor(random, 200, 250));
        //设置内容生成的位置
        g.fillRect(0, 0, width, height);
        //设置内容的字体和大小
        //设置随机 备选的字体类型
        String[] fontTypes = {"\u5b8b\u4f53",
                "\u9ed1\u4f53"};
        int fontTypesLength = fontTypes.length;
        // 设置字体格式
        g.setFont(new Font(fontTypes[random.nextInt(fontTypesLength)],
                Font.BOLD, 10 + random.nextInt(3)));

        g.setColor(getRandColor(random, 160, 200));

        //图片背景上随机生成155条线条，避免通过图片识别破解验证码
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }

        //构造运算表达式
        String content = num1 + " " + arr_chi[operate] + "" + num2 + "=?";
        System.out.println(content);

        //设置写运算表达的颜色
        g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
        //在指定位置绘制指定内容（即运算表达式）
        g.drawString(content, 5, 16);
        //释放此图形的上下文以及它使用的所有系统资源，类似于关闭流
        g.dispose();
        String codeKey = UUIDUtil.getUUID();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageOutputStream imageOutput = ImageIO.createImageOutputStream(byteArrayOutputStream);
        ImageIO.write(image, "JPEG", imageOutput);
        Map<String, Object> imageinfo = new HashMap<String, Object>();
        imageinfo.put("image", Base64.encodeBase64(byteArrayOutputStream.toByteArray()));
        return Base64.encodeBase64(byteArrayOutputStream.toByteArray());
    }
/**
 * @Description
 * @Param [type, request, response]
 * @Return void
 * @Author bunuo 
 * @Date 2019/4/20 13:57
 */
    @RequestMapping(value = "/findSysDict", method = RequestMethod.POST)
    public void findSysDict(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getParameter("username") + "开始登陆");
        PrintWriter writer=null;
        String type=request.getParameter("type");
        try {
            response.setCharacterEncoding("UTF-8");
            writer=response.getWriter();
            Map<String, Object> returnMap = systemService.findSysDict(type);
            writer.write(JsonUtil.map2json(returnMap));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            writer.flush();
            writer.close();
        }
    }
    @RequestMapping(value = "/findCourseSelectList", method = RequestMethod.POST)
    public void findCourseSelectList(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter writer=null;
        String type=request.getParameter("type");
        try {
            response.setCharacterEncoding("UTF-8");
            writer=response.getWriter();
            Map<String, Object> returnMap = systemService.findCourseSelectList();
            writer.write(JsonUtil.map2json(returnMap));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            writer.flush();
            writer.close();
        }
    }
    /**
     * 生成随机色
     */
    Color getRandColor(Random random, int ff, int cc) {
        if (ff > 255) {
            ff = 255;
        }
        if (cc > 255) {
            cc = 255;
        }
        int r = ff + random.nextInt(cc - ff);
        int g = ff + random.nextInt(cc - ff);
        int b = ff + random.nextInt(cc - ff);
        return new Color(r, g, b);
    }
}
