package com.lybyb.journey.uploadFile.controller;

import com.lybyb.journey.order.model.Order;
import com.lybyb.journey.order.service.OrderService;
import com.lybyb.journey.system.model.User;
import com.lybyb.journey.uploadFile.model.Picture;
import com.lybyb.journey.uploadFile.service.UploadService;
import com.lybyb.journey.util.FileUtil;
import com.lybyb.journey.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

@Controller
@RequestMapping(value = "/uploadFile")
/**
 * @author liyanbo
 * 上传图片控制层
 */
public class UploadImgController {
    @Autowired
    private UploadService uploadService;
    @Autowired
    private OrderService orderService;
    private final static String UPLOADDIR = "/files";

    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
    @ResponseBody
    public void uploadImg(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        System.out.println(file.getOriginalFilename());
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            String filePath = "D://img/";
            FileUtil.uploadFile(file.getBytes(), filePath, file.getOriginalFilename());
            String savaPath = request.getRequestURL().toString();
            User user = (User) request.getSession().getAttribute("user");
            Picture picture = new Picture();
            picture.setUserId(user.getId());
            picture.setName(file.getOriginalFilename());
            picture.setUrl(savaPath + "/" + file.getOriginalFilename());
            Map<String, Object> returnMap = uploadService.savePicture(picture);
            writer.write(JsonUtil.map2json(returnMap));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }


    }
    @RequestMapping(value = "/getOrderList",method = RequestMethod.POST)
    public void getOrderList(@RequestBody Order order, HttpServletRequest request, HttpServletResponse response){
        PrintWriter writer = null;
        try {
            response.setCharacterEncoding("UTF-8");
            writer = response.getWriter();
            Map<String, Object> returnMap = orderService.getOrderList(order);
            writer.write(JsonUtil.map2json(returnMap));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }

    @RequestMapping(value = "/getOrderListById",method = RequestMethod.POST)
        public void getOrderListById(HttpServletRequest request, HttpServletResponse response){
            PrintWriter writer = null;
            try {
                response.setCharacterEncoding("UTF-8");
                writer = response.getWriter();
                Long id=Long.parseLong(request.getParameter("id"));
                Map<String, Object> returnMap = orderService.getOrderListById(id);
                writer.write(JsonUtil.map2json(returnMap));
                System.out.println(JsonUtil.map2json(returnMap));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                writer.flush();
                writer.close();
            }
    }

    @RequestMapping(value = "/deleteOrder",method = RequestMethod.POST)
    public void deleteOrder(HttpServletRequest request, HttpServletResponse response){
        PrintWriter writer = null;
        try {
            response.setCharacterEncoding("UTF-8");
            writer = response.getWriter();
            Long id=Long.parseLong(request.getParameter("id"));
            Map<String, Object> returnMap = orderService.deleteOrder(id);
            writer.write(JsonUtil.map2json(returnMap));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }
    @RequestMapping(value = "/getImages", method = RequestMethod.POST)
    @ResponseBody
    public void getImg(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            Map<String, Object> returnMap = uploadService.getImages();
            writer.write(JsonUtil.map2json(returnMap));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }


    @RequestMapping(value = "/saveOrUpdateOrder", method = RequestMethod.POST)
    @ResponseBody
    public void saveOrUpdateOrder(@RequestBody Order order,HttpServletRequest request, HttpServletResponse response) {
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            Map<String, Object> returnMap = orderService.saveOrUpdateOrder(order);
            writer.write(JsonUtil.map2json(returnMap));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }
    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    @ResponseBody
    public void createOrder(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter writer = null;
        try {
            response.setCharacterEncoding("UTF-8");
            writer = response.getWriter();
            Long id=Long.parseLong(request.getParameter("customerId"));
            Order order=new Order();
            order.setCustomerId(id);
            order.setStatus("0");
            Map<String, Object> returnMap = orderService.saveOrUpdateOrder(order);
            writer.write(JsonUtil.map2json(returnMap));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }
    @RequestMapping(value = "/removeImg", method = RequestMethod.POST)
    @ResponseBody
    public void removeImg(@RequestBody Picture picture, HttpServletResponse response) {
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            Map<String, Object> returnMap = uploadService.removeImg(picture);
            writer.write(JsonUtil.map2json(returnMap));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }

    @RequestMapping(value = "/updateImg", method = RequestMethod.POST)
    @ResponseBody
    public void updateImg(@RequestBody Picture picture, HttpServletResponse response) {
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            Map<String, Object> returnMap = uploadService.updateImg(picture);
            writer.write(JsonUtil.map2json(returnMap));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }
    @RequestMapping(value = "/dealOrder", method = RequestMethod.POST)
    @ResponseBody
    public void dealOrder(HttpServletRequest request,HttpServletResponse response) {
        PrintWriter writer = null;
        try {
            response.setCharacterEncoding("UTF-8");
            writer = response.getWriter();
            Long id=Long.parseLong(request.getParameter("id"));
            Map<String, Object> returnMap = orderService.dealOrder(id);
            writer.write(JsonUtil.map2json(returnMap));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }
}
