package edu.scdx.dao;

import edu.scdx.entity.Performance;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Menfer on 2017/7/27.
 * PerformanceDao
 * 和performance表相关的数据库操作
 */

@Component
public interface PerformanceDao {
    //获取所有演出信息
    @Select("select * from Performance")
    List<Performance> getAll();
}
