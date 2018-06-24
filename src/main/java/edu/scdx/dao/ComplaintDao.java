package edu.scdx.dao;

import edu.scdx.entity.Complaint;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


/**
 * Created by Menfer on 2017/7/22.
 * ComplaintDao
 * 与complaint表的数据库操作
 */
@Component
public interface ComplaintDao {

    //获取所有投诉
    @Select("select * from Complaint order by setTime desc")
    List<Complaint> getAll();

    //新建投诉
    @Insert("insert into Complaint(title, userId,content,handleStatus,checkStatus,star,judge,setTime) values(#{title},#{userId},#{content},#{handleStatus},#{checkStatus},#{star},#{judge},now())")
    void addComplaint(@Param("title") String title,
                      @Param("userId") int userId,
                      @Param("content") String content,
                      @Param("handleStatus") int handleStatus,
                      @Param("checkStatus") int checkStatus,
                      @Param("star") int star,
                      @Param("judge") String judge);

    //通过ID获取投诉
    @Select("select * from Complaint where id = #{id}")
    Complaint getComplaintFromId(@Param("id") int id);

    //获取userid获取用户所有投诉
    @Select("select * from Complaint where userId = #{userId}")
    List<Complaint> getComplaintFromUserId(@Param("userId") int userId);

    //获取所有符合操作状态的投诉
    @Select("select * from Complaint where handleStatus = #{handleStatus} order by setTime desc")
    List<Complaint> getComplaintFromHandleStatus(@Param("handleStatus") int handleStatus);

    //获取所有符合审核状态的投诉
    @Select("select * from Complaint where checkStatus = #{checkStatus} order by setTime desc")
    List<Complaint> getComplaintFromCheckStatus(@Param("checkStatus") int checkStatus);

    //获取特定用户的符合处理条件的投诉
    @Select("select * from Complaint where handleStatus = #{handleStatus} and userID=${userId} order by setTime desc")
    List<Complaint> getComplaintFromHandleStatusAndId(@Param("handleStatus") int handleStatus, @Param("userId") int userId);

    //审核投诉
    @Update("update Complaint set checkStatus = #{checkStatus},checkTime = now() where id = #{id}")
    void updateCheckStatus(@Param("checkStatus") int checkStatus, @Param("id") int id);

    //投诉评价
    @Update("update Complaint set star=#{star},judge=#{judge} where id = #{id}")
    void judgeComplaint(@Param("star") int star, @Param("judge") String judge, @Param("id") int id);

    //获取最大ID
    @Select("select id from Complaint where id>=all(select id from Complaint)")
    int getMaxId();

    //获取投诉人ID
    @Select("select userid from complaint where id = #{complaint_id}")
    int getUserIdFromComplaintId(@Param("complaint_id") int complaint_id);

    //回复投诉
    @Update("update complaint set reply = #{reply},handleStatus = 1,handleTime = now() where id = #{id}")
    void updateReplyById(@Param("reply") String reply, @Param("id") int id);

    //删除投诉
    @Delete("delete from complaint where id = #{id}")
    void deleteById(@Param("id") int id);
}
