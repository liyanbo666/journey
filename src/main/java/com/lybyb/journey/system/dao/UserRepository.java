package com.lybyb.journey.system.dao;

import com.lybyb.journey.system.model.SysDict;
import com.lybyb.journey.system.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author liyanbo
 */
@Mapper
public interface UserRepository {
    /**
     * ???????????
     *
     * @param username
     * @return
     */
    @Select("select * from user where username=#{username}")
    User findByUsername(String username);

    @Select("select id as id,label as label,value as value from t_sys_dict where type=#{type}")
    List<SysDict> findSysDict(String type);
    @Select("select id as id ,name as label from course")
    List<SysDict>findCourseSelectList();
}
