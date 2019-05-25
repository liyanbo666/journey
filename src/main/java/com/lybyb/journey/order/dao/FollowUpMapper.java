package com.lybyb.journey.order.dao;

import com.lybyb.journey.order.model.FollowUpRecord;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface FollowUpMapper {
    @Select("select id as id,apply_order_id as applyOrderId, follow_up_plan as followUpPlan,follow_up_process as followUpProcess ,create_time as createTime from follow_up_record where apply_order_id=#{id}")
    List<FollowUpRecord>  findFollowUpRecordList(Long id);
    @Update("update follow_up_record set follow_up_plan=#{followUpPlan},follow_up_process=#{followUpProcess} where id=#{id}")
    void updateFollowUpRecord(FollowUpRecord followUpRecord);
    @Delete("delete from follow_up_record where id=#{id}")
    void deleteFollowUpRecord(Long id);
    @Insert("insert into follow_up_record (apply_order_id,follow_up_process,follow_up_plan,create_time) VALUE (#{applyOrderId},#{followUpProcess},#{followUpPlan},now())")
    void saveFollowUpRecord(FollowUpRecord followUpRecord);
}
