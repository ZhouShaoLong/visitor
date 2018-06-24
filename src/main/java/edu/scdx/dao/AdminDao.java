package edu.scdx.dao;

import edu.scdx.entity.Admin;
import edu.scdx.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Menfer on 2017/7/27.
 * AdminDao类
 * 实现与admin表的数据库交互
 */
@Component
public interface AdminDao {
    //获取所有管理员列表
    @Select("select * from admin")
    List<User> getAll();

    //增加管理员
    @Insert("insert into admin values(#{admin_id},#{email},#{password},#{name})")
    boolean register(@Param("admin_id") String admin_id, @Param("email") String email, @Param("password") String password, @Param("name") String name);

    //登录验证
    @Select("select * from admin where email = #{email} and password = #{password}")
    List<Admin> login(@Param("email") String email, @Param("password") String password);

    //通过email获取admin
    @Select("select * from admin where email = #{email}")
    Admin getAdminFromEmail(@Param("email") String email);

    //通过admin_id获取ammin
    @Select("select * from admin where admin_id = #{admin_id}")
    Admin getAdminFromId(@Param("admin_id") int admin_id);
}
