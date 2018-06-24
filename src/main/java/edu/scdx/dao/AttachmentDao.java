package edu.scdx.dao;

import edu.scdx.entity.Attachment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Menfer on 2017/7/24.
 * AttachmentDao
 * 与attachment表的数据库操作
 */

@Component
public interface AttachmentDao {
    //通过投诉ID获取附件
    @Select("select * from attachment where complaint_id = #{complaint_id}")
    List<Attachment> getFromComplaintId(@Param("complaint_id") int complaint_id);

    //添加附件信息
    @Insert("insert into Attachment values(#{complaint_id}, #{filename},#{type})")
    void addAttachment(@Param("complaint_id") int complaint_id, @Param("filename") String filename, @Param("type") int type);

}
