package edu.scdx.service;

import edu.scdx.dao.HotelDao;
import edu.scdx.dao.RoomDao;
import edu.scdx.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Menfer on 2017/7/26.
 */
@Component
public class HotelService {
    @Autowired
    HotelDao hotelDao;
    @Autowired
    RoomDao roomDao;

    /**
     *  函数名：getAll
     *  描述：获取全部的酒店信息
     *  输入参数：无
     *  返回值：全部酒店信息的list
     */

    public List getAll(){
        return hotelDao.getAll();
    }

    /**
     *  函数名：getMinPrice
     *  描述：获取酒店的最低价格
     *  输入参数：
     *  int hotel_id   酒店的id
     *  返回值：酒店的最低价格
     */

    public double getMinPrice(int hotel_id) {
        return hotelDao.getMinPrice(hotel_id);
    }

    /**
     *  函数名：getSearchdResult
     *  描述： 根据用户选定的查询条件查询符合条件的酒店
     *  输入参数：
     *  String city 城市名
     *  int star    星级
     *  double minPrice 最低价格
     *  double maxPrice 最高价格
     *  返回值：符合条件的酒店列表
     */

    public List getSearchdResult(String city, int star, double minPrice, double maxPrice){
        return hotelDao.getSearchResult(city, star, minPrice, maxPrice);
    }
}
