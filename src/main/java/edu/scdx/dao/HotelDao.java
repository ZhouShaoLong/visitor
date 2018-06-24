package edu.scdx.dao;

import edu.scdx.entity.Hotel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Menfer on 2017/7/26.
 * HotelDao
 * 与hotel表的数据库操作
 */
@Component
public interface HotelDao {
    //获取所有酒店
    @Select("select * from Hotel")
    List<Hotel> getAll();

    //获取酒店房间最低价
    @Select("select min(price) from (select * from room where hotel_id = #{hotel_id})")
    double getMinPrice(@Param("hotel_id") int hotel_id);

    //获取符合信息的酒店列表
    @Select("select * from Hotel where city='${city}' and star=${star} and minPrice>${minPrice} and minPrice<${maxPrice}")
    List<Hotel> getSearchResult(@Param("city") String city, @Param("star") int star, @Param("minPrice") double minPrice, @Param("maxPrice") double maxPrice);
}
