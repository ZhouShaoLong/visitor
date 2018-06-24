package edu.scdx.service;

import edu.scdx.Utils.SessionUtils;
import edu.scdx.Utils.UserFilter;
import edu.scdx.entity.User;
import edu.scdx.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * Created by Menfer Share on 2017-07-22.
 * 实现与用户操作有关的方法
 */

@Component
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserFilter userFilter;

    /**
     * login方法实现用户登录，登录成功后创建session
     * session有user属性，内容为当前User对象
     * 参数：email ： 用户eamil
     *       password： 密码
     * 返回值：int
     *        0：用户名或密码错误
     *        1：登录成功
     **/
    public int login(String email, String password){
        HttpSession session = SessionUtils.getCurrentSession();
        session.removeAttribute("user");
        if (userDao.login(email,password).isEmpty()){
            return 0;
        }else {
            session.setAttribute("user", userDao.getUserFromEmail(email));
            return 1;
        }
    }

    /**
     * register方法实现用户登注册
     * 参数：
     * User user 用户的全部信息
     * 返回值：
     * 注册结果信息
     **/

    public String register(User user) {
        //验证输入信息是否非法
        String statusCode = "";
        if (userFilter.name_stringFilter(user.getName()) && userDao.checkName(user.getName()).isEmpty()) {
            statusCode += "1";
        } else {
            statusCode += "0";
        }
        if (userFilter.email_stringFilter(user.getEmail()) && userDao.checkEmail(user.getEmail()).isEmpty()) {
            statusCode += "1";
        } else {
            statusCode += "0";
        }
        if (userFilter.password_stringFilter(user.getPassword())) {
            statusCode += "1";
        } else {
            statusCode += "0";
        }
        if (userFilter.birthday_stringFilter(user.getBirthday())) {
            statusCode += "1";
        } else {
            statusCode += "0";
        }
        if (userFilter.address_stringFilter(user.getAddress())) {
            statusCode += "1";
        } else {
            statusCode += "0";
        }
        if (userFilter.qq_stringFilter(user.getQq()) && userDao.checkQq(user.getQq()).isEmpty()) {
            statusCode += "1";
        } else {
            statusCode += "0";
        }
        if (userFilter.phone_stringFilter(user.getPhone()) && userDao.checkPhone(user.getPhone()).isEmpty()) {
            statusCode += "1";
        } else {
            statusCode += "0";
        }
        String Error = "";

        for (int i = 0; i < statusCode.length(); i++) {
            if (statusCode.charAt(i) != '1') {
                switch (i) {
                    case 0:
                        Error += "名字格式不合法或重复。\n";
                        break;
                    case 1:
                        Error += "邮箱格式不合法或重复。\n";
                        break;
                    case 2:
                        Error += "密码格式不合法。\n";
                        break;
                    case 3:
                        Error += "性别输入格式错误。\n";
                        break;
                    case 4:
                        Error += "地址输入长度过长。\n";
                        break;
                    case 5:
                        Error += "QQ号格式错误或重复。\n";
                        break;
                    case 6:
                        Error += "电话号码格式错误或重复。\n";
                        break;
                    default:
                        break;
                }
            }
        }
        if (Error!="") {
            return "注册信息有错错误:\n"+Error;
        }
        userDao.register(user.getName(), user.getEmail(), user.getPassword(), user.getBirthday(), user.getPhone(), user.getAddress(), user.getQq());
        return "注册成功";
    }

}
