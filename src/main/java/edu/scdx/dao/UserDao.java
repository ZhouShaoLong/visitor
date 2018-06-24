package edu.scdx.dao;

import edu.scdx.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Menfer on 2017-07-20.
 * UserDao
 * 与user表相关的数据库操作
 */
@Component
public interface UserDao {

    //获取所有用户
    @Select("select * from user")
    List<User> getAll();

    //验证用户登录
    @Select("select * from user where email = #{email} and password = #{password}")
    List<User> login(@Param("email") String email, @Param("password") String password);

    //通过email获取用户
    @Select("select * from user where email = #{email}")
    User getUserFromEmail(@Param("email") String email);

    //通过ID获取用户
    @Select("select * from user where id = #{id}")
    User getUserFromId(@Param("id") int id);

    //通过用户昵称寻找符合条件的用户列表
    @Select("select * from user where name = #{name}")
    List<User> checkName(@Param("name") String name);

    //通过email检查用户
    @Select("select * from user where email = #{email}")
    List<User> checkEmail(@Param("email") String email);

    //通过QQ获取用户
    @Select("select * from user where qq = #{qq}")
    List<User> checkQq(@Param("qq") String qq);

    //通过电话获取用户
    @Select("select * from user where phone = #{phone}")
    List<User> checkPhone(@Param("phone") String phone);

    //插入用户，注册成功
    @Insert("insert into User value (NULL , #{name} ,#{email} ,#{password} ,#{sex} ,#{phone} ,#{address} ,#{qq})")
    boolean register(@Param("name") String name, @Param("email") String email, @Param("password") String password, @Param("sex") String sex, @Param("phone") String phone, @Param("address") String address, @Param("qq") String qq);

}
