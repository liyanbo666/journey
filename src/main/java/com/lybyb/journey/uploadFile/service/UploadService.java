package com.lybyb.journey.uploadFile.service;

import com.lybyb.journey.uploadFile.model.Picture;

import java.util.Map;

public interface UploadService {
    /**
     * 上传图片
     * @param picture
     * @return
     */
    Map<String,Object> savePicture(Picture picture);

    /**
     * 获取图片
     * @return
     */
    Map<String,Object> getImages();

    /**
     * 删除图片
     * @param picture
     * @return
     */
    Map<String,Object> removeImg(Picture picture);

    /**
     * 修改图片
     * @param picture
     * @return
     */
    Map<String,Object>updateImg(Picture picture);
}
