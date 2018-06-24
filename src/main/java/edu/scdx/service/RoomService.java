package edu.scdx.service;

import edu.scdx.dao.RoomDao;
import edu.scdx.entity.Room;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Menfer on 2017/7/26.
 */
@Component
public class RoomService {
    @Autowired
    private RoomDao roomDao;

    /**
     *  函数名：updateRoomInfo
     *  描述：更新房间信息
     *  输入参数:
     *  double price    房间的价格
     *  int orderStatus 房间是否被预定 0未被预定 1已被预定
     *  String startTime    预定房间的开始时间
     *  String endTime      预定房间的结束时间
     *  int hotel_id        酒店的id
     *  String room_num     房间的编号
     *  返回值：
     */
    public void updateRoomInfo(double price,int orderStatus,String startTime,String endTime,int hotel_id, String room_num){
        if(startTime.equals("")){
            startTime = null;
        }
        if (endTime.equals("")){
            endTime=null;
        }
        roomDao.updateRoomInfo(price, orderStatus, startTime, endTime, hotel_id, room_num);
    }

    /**
     *  函数名：getRoomFromId
     *  描述：获取一个酒店的房间信息
     *  输入参数：
     *  int hotel_id 酒店的id
     *  返回值：酒店的所有房间的信息
     */
    public List<Room> getRoomFromId(int hotel_id){
        return roomDao.getRoomFromHotelId(hotel_id);
    }
}

