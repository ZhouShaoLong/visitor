package edu.scdx.dao;

import edu.scdx.entity.Admin;
import edu.scdx.entity.Notice;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Menfer on 2017/7/26.
 * NoticeDao
 * 与notice表相关的数据库操作
 */

@Component
public interface NoticeDao {
    //插入应急信息
    @Insert("insert into notice value ( null, now(), #{content}, #{id}, #{title}, #{endtime} )")
    boolean Publish(@Param("content") String content,@Param("id") int id,@Param("title") String title,@Param("endtime") String endtime);

    //获取所有有效应急信息
    @Select("select * from notice where endtime>now()")
    List<Notice> getNoticeList();

    //通过ID获取应急信息
    @Select("select * from notice where notice_id = #{id}")
    Notice getDetailById(@Param("id") int id);

    //通过admin_id获取admin名字
    @Select("select * from admin where admin_id = #{id}")
    Admin getAdminNameById(@Param("id") int id);

    //删除应急信息
    @Delete("delete from notice where notice_id = #{id}")
    boolean deleteNoticeById(@Param("id") int id);

    //修改应急信息
    @Update("update notice set title = #{title},content = #{content},endtime = #{endtime} where notice_id = #{id}")
    boolean insertModify(@Param("id") int id,@Param("title") String title,@Param("content") String content,@Param("endtime") String endtime);

}
