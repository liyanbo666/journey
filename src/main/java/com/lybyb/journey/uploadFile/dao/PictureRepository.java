package com.lybyb.journey.uploadFile.dao;

import com.lybyb.journey.uploadFile.model.Picture;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PictureRepository {
    /**
     * 保存图片
     *
     * @param picture
     * @return
     */

    int savePicture(Picture picture);

    /**
     * 获取图片
     *
     * @param userId
     * @return
     */
    @Select("select id as id,url as url,name as name,create_time as createTime,description as description from picture where user_id=#{userId}")
    List<Picture> getAllImage(Long userId);

    /**
     * 更新图片描述
     * @param picture
     * @return
     */
    @Update("update picture set description=#{description} where id=#{id}")
    int updateImg(Picture picture);
    /**
     * 删除图片
     *
     * @param id
     * @return
     */
    @Delete("delete from picture where id=#{id}")
    int removeImg(Long id);

    /**
     * 通过图片名称判断图片是否已存在
     * @param name
     * @return
     */
    @Select("select count(1) from picture where name=#{name}")
    int imgIsExist(String name);
}
