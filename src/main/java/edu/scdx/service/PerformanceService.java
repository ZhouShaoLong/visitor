package edu.scdx.service;

import edu.scdx.dao.PerformanceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Menfer on 2017/7/27.
 */
@Component
public class PerformanceService {
    @Autowired
    PerformanceDao performanceDao;

    /**
     *  函数名：getAll
     *  描述：获取所有演出信息
     *  输入参数：无
     *  返回值：所有的演出信息
     */
    public List getAll(){
        return performanceDao.getAll();
    }
}
