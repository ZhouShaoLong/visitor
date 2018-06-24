package edu.scdx.controller;

import edu.scdx.Utils.SessionUtils;
import edu.scdx.entity.Admin;
import edu.scdx.service.AdminService;
import edu.scdx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Menfer on 2017/7/27.
 * AdminController类
 * 用于处理与管理员相关的URL映射
 */

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * get()
     * 获取管理员列表
     * 主要用于调试
     * */
    @RequestMapping("/list.do")
    public String get(Model model, HttpServletRequest request){
        model.addAttribute("list",adminService.getAll());
        HttpSession session = SessionUtils.getCurrentSession();
        model.addAttribute("admin", session.getAttribute("admin"));
        return "list";
    }

    /**
     * login（）
     * 管理员登录
     * 参数：email 管理员邮箱
     *       password 密码
     * */
    @RequestMapping("/login.do")
    public String login(Model model, String email, String password){
        HttpSession session = SessionUtils.getCurrentSession();
        int res = adminService.login(email, password);
        if (1 == res){
            //登录成功的操作
            model.addAttribute("admin", session.getAttribute("admin"));
            return "admin";
        }else {
            //登陆不成功的操作
            return "adminLogin";
        }

    }

    /**
     * 跳转到管理员登录界面
     * */
    @RequestMapping("/toAdminLogin.do")
    public String toAdminLogin(){
        return "adminLogin";
    }

    /**
     * 跳转到管理员主页
     * */
    @RequestMapping("/toAdmin")
    public String toAdmin(){
        return "admin";
    }
}
