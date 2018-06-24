package edu.scdx.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Menfer on 2017/7/27.
 * AppController类
 * 系统部分非功能性URL映射
 */
@Controller
public class AppController {
   //跳转到首页
    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }

    //跳转到关于我们界面
    @RequestMapping("/aboutus")
    public String aboutus(){
        return "about";
    }

    //跳转到旅游信息界面
    @RequestMapping("/toVisit")
    public String visit(){
        return "visit";
    }
}
