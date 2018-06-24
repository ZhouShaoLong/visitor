package edu.scdx.controller;

import edu.scdx.Utils.SessionUtils;
import edu.scdx.entity.Complaint;
import edu.scdx.entity.User;
import edu.scdx.service.ComplaintService;
import edu.scdx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Menfer on 2017/7/22.
 * UserrController
 * 用户的操作URL映射
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ComplaintService complaintService;

    /**
     * 登录功能
     * 参数：email 电子邮箱
     *       password 密码
     * */
    @RequestMapping("/login.do")
    public String login(Model model, String email, String password){
        HttpSession session = SessionUtils.getCurrentSession();
        int res = userService.login(email, password);
        if (1 == res){
            //登录成功的操作
            model.addAttribute("user", session.getAttribute("user"));
            return "index";
        }else {
            //登陆不成功的操作
            return "login";
        }
    }

    //跳转到登录界面
    @RequestMapping("/toLogin.do")
    public String toLogin(){
        return "login";
    }

    //跳转到用户详情界面
    @RequestMapping("/detail")
    public String toDetail(Model model){
        HttpSession session = SessionUtils.getCurrentSession();
        User user = (User)session.getAttribute("user");
        List<Complaint> complaints = complaintService.getComplaintByUserId(user.getId());
        List<Complaint> handledComplaints = complaintService.getHandledComplaintFromUserId(user.getId());
        List<Complaint> unHandledComplaints = complaintService.getUnHandledComplaintFromUserId(user.getId());
        model.addAttribute("user",user);
        model.addAttribute("complaints",complaints);
        model.addAttribute("handledComplaints",handledComplaints);
        model.addAttribute("unHandledComplaints",unHandledComplaints);
        return "userDetail";
    }

    //跳转到注册界面
    @RequestMapping("/toRegister.do")
    public String ToRegister(Model model){
        return "register";
    }

    /**
     * 注册
     * 参数：name 昵称
     *       email 邮箱
     *       password 密码
     *       birthday 生日
     *       phone 电话号码
     *       qq QQ号码
     *       address 地址
     * */
    @RequestMapping("/register.do")
    public String register(Model model,String name,String email,String password,String cpassword,String birthday,String phone,String qq,String address){
        User user = new User();
        if(password.equals(cpassword)){
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setBirthday(birthday);
            user.setPhone(phone);
            user.setQq(qq);
            user.setAddress(address);
        }
        model.addAttribute("statusCode",userService.register(user));
        return "login";
    }


    /**
     * 用户注销
     * */
    @RequestMapping("/logout")
    public String logout(){
        HttpSession session = SessionUtils.getCurrentSession();
        session.removeAttribute("user");
        return "index";
    }
}
