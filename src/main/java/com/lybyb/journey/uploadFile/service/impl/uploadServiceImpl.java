package com.lybyb.journey.uploadFile.service.impl;

import com.lybyb.journey.system.model.User;
import com.lybyb.journey.uploadFile.dao.PictureRepository;
import com.lybyb.journey.uploadFile.model.Picture;
import com.lybyb.journey.uploadFile.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class uploadServiceImpl implements UploadService {
    @Autowired
    private PictureRepository pictureRepository;
    @Autowired
    private HttpSession session;

    @Override
    public Map<String, Object> savePicture(Picture picture) {
        Map<String, Object> returnMap = new HashMap<>();
        int num = pictureRepository.imgIsExist(picture.getName());
        if (num > 0) {
            returnMap.put("code", "isExist");
            returnMap.put("msg", "文件名" + picture.getName() + "已存在，请修改文件名后再次上传");
        } else {
            int count = pictureRepository.savePicture(picture);
            if (count > 0) {
                returnMap.put("code", "200");
                returnMap.put("msg", "图片上传成功");
                returnMap.put("data", picture);
            } else {
                returnMap.put("code", "0000");
                returnMap.put("msg", "图片上传失败");
            }
        }
        return returnMap;
    }

    @Override
    public Map<String, Object> getImages() {
        Map<String, Object> returnMap = new HashMap<>();
        User user = (User) session.getAttribute("user");
        List<Picture> pictures = pictureRepository.getAllImage(user.getId());
        returnMap.put("code", "200");
        returnMap.put("msg", "图片获取成功");
        returnMap.put("data", pictures);
        return returnMap;
    }

    @Override
    public Map<String, Object> updateImg(Picture picture) {
        Map<String, Object> returnMap = new HashMap<>();
        try {
            pictureRepository.updateImg(picture);
            returnMap.put("code", "200");
            returnMap.put("msg", "图片修改成功");
        } catch (Exception e) {
            returnMap.put("code", "0000");
            returnMap.put("msg", "图片修改失败");
        }
        return returnMap;
    }

    @Override
    public Map<String, Object> removeImg(Picture picture) {
        File removeFile = new File("D://img/" + picture.getName());
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("code", "0000");
        returnMap.put("msg", "图片删除失败");
        int count = pictureRepository.removeImg(picture.getId());
        if (count == 1) {
            returnMap.put("code", "200");
            returnMap.put("msg", "图片删除成功");
        }
        removeFile.delete();
        return returnMap;
    }
}
