package edu.scdx.service;

import edu.scdx.Utils.SessionUtils;
import edu.scdx.dao.AdminDao;
import edu.scdx.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Menfer Share on 2017-07-22.
 * 实现与管理员操作有关的方法
 */

@Component
public class AdminService {
    @Autowired
    private AdminDao adminDao;

    public List getAll(){
        return adminDao.getAll();
    }

    /**
     * login方法实现管理员登录，登录成功后创建session
     * session有admin属性，内容为当前admin对象
     * 参数：email ： 管理员eamil
     *       password： 密码
     * 返回值：int
     *        0：用户名或密码错误
     *        1：登录成功
     **/
    public int login(String email, String password){
        HttpSession session = SessionUtils.getCurrentSession();
        session.removeAttribute("admin");
        if (adminDao.login(email,password).isEmpty()){
            return 0;
        }else {
            session.setAttribute("admin", adminDao.getAdminFromEmail(email));
            return 1;
        }
    }

}
