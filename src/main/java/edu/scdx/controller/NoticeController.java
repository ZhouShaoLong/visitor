package edu.scdx.controller;

import edu.scdx.entity.Admin;
import edu.scdx.service.NoticeService;
import edu.scdx.Utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Menfer on 2017/7/26.
 * NoticeController
 * 应急信息相关功能的URL映射
 */

@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    public NoticeService noticeService;

    //跳转到添加应急信息输入界面
    @RequestMapping("/toNotice.do")
    public String toNotice(Model model) {
        HttpSession session = SessionUtils.getCurrentSession();
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin != null) {
            return "addNotice";
        }
        String failMessage;
        failMessage = "只有管理员可以执行此操作，如果您是管理员，请先登录。";
        model.addAttribute("failmessage",failMessage);
        return "failReason";
    }

    /**
     * 发布应急信息
     * 参数：title 信息标题
     *       content 内容
     *       startTime 开始时间
     *       endTIme 有效时间
     * */
    @RequestMapping("/Publish.do")
    public String PublishMessage(Model model, String title, String content, String endtime) {
        //获取session
        HttpSession session = SessionUtils.getCurrentSession();
        Admin admin = (Admin) session.getAttribute("admin");
        //检验是否登录
        if (admin != null) {
            //检验紧急信息的截止日期是否晚于当前时间
            Date date = new Date();
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
                Date date1 = sdf.parse(endtime);
                if (date.before(date1)) {
                    noticeService.Publish(title, admin.getAdmin_id(),content, endtime);
                    return "admin";
                } else {
                    String failMessage;
                    failMessage = "有限日期不可早于现在。";
                    model.addAttribute("failmessage",failMessage);
                    return "failReason";
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String failMessage;
            failMessage = "未知异常，请联系开发人员。";
            model.addAttribute("failmessage",failMessage);
            return "failReason";
        } else {
            String failMessage;
            failMessage = "只有管理员可以执行此操作，如果您是管理员，请先登录。";
            model.addAttribute("failmessage",failMessage);
            return "failReason";
        }
    }

    /**
     * 跳转到应急信息列表
     * 参数：page 显示页数
     * */
    @RequestMapping("/noticeList.do")
    public String noticeList(Model model, int page) {
        List list = noticeService.getNoticeList();
        model.addAttribute("list", list);
        int realPage = page;
        int totalPage = 0;
        if(list.size()<=15){
            totalPage = 1;
        }else if((list.size()%15)==0){
            totalPage = list.size()/15;
        }else {
            totalPage = list.size()/15+1;
        }
        if(page<=1){
            realPage = 1;
        }
        if (page>totalPage){
            realPage = totalPage;
        }
        model.addAttribute("page",realPage);
        model.addAttribute("totalPage",totalPage);
        return "noticeList";
    }

    /**
     * 显示信息细节
     * 参数：id 信息ID
     *       admin_id 管理员ID
     * */
    @RequestMapping("/detail.do")
    public String detail(Model model, int id, int admin_id) {
        model.addAttribute("detail", noticeService.getDetailById(id));
        model.addAttribute("admin", noticeService.getAdminNameById(admin_id));
        return "noticeDetail";
    }

    /**
     * 删除应急信息
     * 参数：id 应急信息ID
     * */
    @RequestMapping("/delete.do")
    public String delete(Model model, int id) {
        if (noticeService.deleteNoticeById(id)) {
            List list = noticeService.getNoticeList();
            model.addAttribute("list", list);
            int totalPage = 0;
            if(list.size()<=15){
                totalPage = 1;
            }else if((list.size()%15)==0){
                totalPage = list.size()/15;
            }else {
                totalPage = list.size()/15+1;
            }
            model.addAttribute("page",1);
            model.addAttribute("totalPage",totalPage);
            return "noticeList";
        } else {
            String failMessage;
            failMessage = "只有管理员可以执行此操作，如果您是管理员，请先登录。";
            model.addAttribute("failmessage",failMessage);
            return "failReason";
        }
    }

    /**
     * 跳转到应急信息修改的输入界面
     * 参数： id 应急信息ID
     * */
    @RequestMapping("/modify.do")
    public String modify(Model model, int id) {
        model.addAttribute("modify", noticeService.getDetailById(id));
        return "noticeModify";
    }

    /**
     * 修改信息
     * 参数： id 应急信息ID
     *        title 应急信息标题
     *        content 内容
     *        endTime 结束时间
     * */
    @RequestMapping("/insertModify.do")
    public String insertModify(Model model, int id, String title, String content, String endtime) {
        if (noticeService.insertModify(id, title, content, endtime)) {
            List list = noticeService.getNoticeList();
            model.addAttribute("list", list);
            int totalPage = 0;
            if(list.size()<=15){
                totalPage = 1;
            }else if((list.size()%15)==0){
                totalPage = list.size()/15;
            }else {
                totalPage = list.size()/15+1;
            }
            model.addAttribute("page",1);
            model.addAttribute("totalPage",totalPage);
            return "noticeList";
        } else {
            String failMessage;
            failMessage = "只有管理员可以执行此操作，如果您是管理员，请先登录。";
            model.addAttribute("failmessage",failMessage);
            return "failReason";
        }

    }
}
