package edu.scdx.dao;

import edu.scdx.entity.Room;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Menfer on 2017/7/26.
 * RoomDao
 * 和room表相关的数据库操作
 */
@Component
public interface RoomDao {
    //通过hotel_id获取酒店的所有房间
    @Select("select * from room where hotel_id = #{hotel_id}")
    List<Room> getRoomFromHotelId(@Param("hotel_id") int hotel_id);

    //更新酒店的房间信息
    @Update("update room set price = #{price}, orderStatus = #{orderStatus}, startTime = #{startTime}, endTime = #{endTime} where hotel_id = #{hotel_id} and room_num = '#{room_num}'")
    void updateRoomInfo(@Param("price") double price, @Param("orderStatus") int orderStatus,@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("hotel_id") int hotel_id, @Param("room_num") String room_num);

}
