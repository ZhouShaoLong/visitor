package edu.scdx.controller;

import edu.scdx.Utils.SessionUtils;
import edu.scdx.entity.Admin;
import edu.scdx.entity.Complaint;
import edu.scdx.entity.User;
import edu.scdx.service.AttachmentService;
import edu.scdx.service.ComplaintService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebParam;
import javax.rmi.CORBA.Util;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Menfer on 2017/7/22.
 *ComplaintController
 * 与投诉功能有关的URL映射
 */
@Controller
@RequestMapping("/complaint")
public class ComplaintController {
    @Autowired
    private ComplaintService complaintService;

    @Autowired
    private AttachmentService attachmentService;

    //跳转到添加投诉的输入界面
    @RequestMapping("/addInput")
    public String toAddComplaint(){
        return "addComplaint";
    }

    /**
     * addComplaint()
     * 参数：files 上传的文件
     *       request http请求
     * */
    @RequestMapping("/add")
    public String addComplaint(Model model, HttpServletRequest request,MultipartFile[] files) throws IOException{
        String title = request.getParameter("title");
        String failMessage;
        HttpSession session = SessionUtils.getCurrentSession();
        User user = (User)session.getAttribute("user");
        //未登录时无法投诉，跳到登录界面
        if (user == null){
            failMessage = "未登录用户无法提交投诉，请先登录。";
            model.addAttribute("failmessage",failMessage);
            return "failReason";
        }
        int userId = user.getId();
        String content = request.getParameter("content");
        int handleStatus = 0;
        int checkStatus = 0;
        int star = 0;
        String judge = "";
        complaintService.addComplaint(title,userId,content,handleStatus,checkStatus,star,judge);
        for(int i=0;i<files.length;i++){
            int type = -1;
            MultipartFile file = files[i];
            String filename = System.currentTimeMillis()+file.getOriginalFilename();
            if(filename.endsWith("jpg")||filename.endsWith("png")||filename.endsWith("jpeg")||filename.endsWith("gif")||filename.endsWith("bmp")){
                type = 0;
            }else if(filename.endsWith("mp4")) {      //只支持mp4文件
                type = 1;
            }
            if(type==-1){
                continue;
            }
            File imageFile = new File(request.getServletContext().getRealPath("/image"),filename);
            FileUtils.copyInputStreamToFile(file.getInputStream(), imageFile);
            attachmentService.addAttachment(filename,type);
        }
        List list = complaintService.getAll();
        model.addAttribute("list", complaintService.getAll());
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
        return "complaintList";
    }

    //显示所有投诉
    @RequestMapping("/showAll")
    public String showAll(Model model,int page){
        HttpSession session = SessionUtils.getCurrentSession();
        Admin admin = (Admin) (session.getAttribute("admin"));
        if(admin == null){
            String failMessage;
            failMessage = "非管理员用户只能查看通过审核的投诉，如果您是管理员，请先登录再进行此操作。";
            model.addAttribute("failmessage",failMessage);
            return "failReason";
        }
        List list = complaintService.getAll();
        model.addAttribute("list", complaintService.getAll());
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
        return "complaintList";
    }

    /**
     * 回复列表界面
     * 参数： page 显示的页
     * */
    @RequestMapping("/toReply")
    public String toReply(Model model,int page){
        HttpSession session = SessionUtils.getCurrentSession();
        Admin admin = (Admin) (session.getAttribute("admin"));
        if(admin == null){
            String failMessage;
            failMessage = "非管理员用户无法使用该功能，如果您是管理员，请先登录再进行此操作。";
            model.addAttribute("failmessage",failMessage);
            return "failReason";
        }
        List list = complaintService.getAll();
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
        return "handleComplaintList";
    }

    /**
     *跳转到回复输入界面
     *参数 complaint_id 投诉ID
     */
    @RequestMapping("/toReplyInput")
    public String toReplyInput(Model model, int complaint_id){
        HttpSession session = SessionUtils.getCurrentSession();
        Admin admin = (Admin) (session.getAttribute("admin"));
        if(admin == null){
            String failMessage;
            failMessage = "非管理员用户无法使用该功能，如果您是管理员，请先登录再进行此操作。";
            model.addAttribute("failmessage",failMessage);
            return "failReason";
        }
        model.addAttribute("pictures",attachmentService.getFromComplaintId(complaint_id));
        model.addAttribute("complaint",complaintService.getComplaintFromId(complaint_id));
        model.addAttribute("user", SessionUtils.getCurrentSession().getAttribute("user"));
        model.addAttribute("complaint_user",complaintService.getUserFromId(complaintService.getUserIdFromComplaintId(complaint_id)));
        return "replyComplaint";
    }

    /**
     * 回复投诉
     * 参数： reply 回复
     *        complaint_id 投诉ID
     * */
    @RequestMapping("/reply")
    public String reply(Model model, String reply, int complaint_id){
        complaintService.replyComplaint(reply, complaint_id);
        HttpSession session = SessionUtils.getCurrentSession();
        Admin admin = (Admin) (session.getAttribute("admin"));
        if(admin == null){
            String failMessage;
            failMessage = "非管理员用户无法使用该功能，如果您是管理员，请先登录再进行此操作。";
            model.addAttribute("failmessage",failMessage);
            return "failReason";
        }
        List list = complaintService.getAll();
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
        return "handleComplaintList";
    }

    /**
     *跳转到审核列表
     *参数：page 显示的页
     * */
    @RequestMapping("/toCheck")
    public String toCheck(Model model,int page){
        HttpSession session = SessionUtils.getCurrentSession();
        Admin admin = (Admin) (session.getAttribute("admin"));
        if(admin == null){
            String failMessage;
            failMessage = "非管理员用户无法使用该功能，如果您是管理员，请先登录再进行此操作。";
            model.addAttribute("failmessage",failMessage);
            return "failReason";
        }
        List list = complaintService.getAll();
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
        model.addAttribute("list", complaintService.getAll());
        return "checkComplaintList";
    }

    /**
     * 审核投诉
     * 参数：checkStatus 审核状态
     *       complaint_id 投诉ID
     * */
    @RequestMapping("/check")
    public String check(Model model, int checkStatus, int complaint_id){
        complaintService.checkComplaint(checkStatus, complaint_id);
        HttpSession session = SessionUtils.getCurrentSession();
        Admin admin = (Admin) (session.getAttribute("admin"));
        if(admin == null){
            String failMessage;
            failMessage = "非管理员用户无法使用该功能，如果您是管理员，请先登录再进行此操作。";
            model.addAttribute("failmessage",failMessage);
            return "failReason";
        }
        List list = complaintService.getAll();
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
        model.addAttribute("list", complaintService.getAll());
        return "handleComplaintList";
    }

    /**
     * 显示投诉详情
     * 参数： complaint_id 投诉ID
     * */
    @RequestMapping("/detail")
    public String getDetail(Model model, int complaint_id){
        model.addAttribute("pictures",attachmentService.getFromComplaintId(complaint_id));
        model.addAttribute("complaint",complaintService.getComplaintFromId(complaint_id));
        model.addAttribute("user", SessionUtils.getCurrentSession().getAttribute("user"));
        model.addAttribute("complaint_user",complaintService.getUserFromId(complaintService.getUserIdFromComplaintId(complaint_id)));
        return "complaintDetail";
    }

    /**
     * 评价投诉
     * 参数： star 评价星级
     *        judge 评价
     *        complaint_id 投诉ID
     * */
    @RequestMapping("/judge")
    public String judge(Model model,int star, String judge, int complaint_id){
        HttpSession session = SessionUtils.getCurrentSession();
        User user = (User)(session.getAttribute("user"));
        if(user == null){
            String failMessage;
            failMessage = "请先登录再执行此操作。";
            model.addAttribute("failmessage",failMessage);
            return "failReason";
        }
        complaintService.judgeComplaint(star, judge, complaint_id);
        List list = complaintService.getAllPublic();
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
        model.addAttribute("list",list);
        return "publicComplaintList";
    }

    //跳转到评价界面
    @RequestMapping("toJudge")
    public String toJudge(Model model, int complaint_id){
        HttpSession session = SessionUtils.getCurrentSession();
        User user = (User)(session.getAttribute("user"));
        if(user == null){
            String failMessage;
            failMessage = "请先登录再执行此操作。";
            model.addAttribute("failmessage",failMessage);
            return "failReason";
        }
        Complaint complaint = complaintService.getComplaintFromId(complaint_id);
        if(complaint.getUserId()!=user.getId()){
            String failMessage;
            failMessage = "只有提交投诉的用户可以评价该条投诉。";
            model.addAttribute("failmessage",failMessage);
            return "failReason";
        }else {
            model.addAttribute("complaint", complaint);
            model.addAttribute("user",user);
            return "judgeComplaint";
        }
    }

    /**
     * 用户可见已审核通过的投诉
     * 参数： page 显示的页
     * */
    @RequestMapping("/showAllPublic")
    public String showAllPublic(Model model,int page){
        List list = complaintService.getAllPublic();
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
        model.addAttribute("list",list);
        return "publicComplaintList";
    }

    /**
     * 删除投诉
     * 参数： complaint_id 投诉ID
     * */
    @RequestMapping("/delete")
    public String deleteComplaint(Model model,int complaint_id){
        HttpSession session = SessionUtils.getCurrentSession();
        Admin admin = (Admin) (session.getAttribute("admin"));
        if(admin == null){
            String failMessage;
            failMessage = "只有管理员可以执行此操作，如果您是管理员，请先登录。";
            model.addAttribute("failmessage",failMessage);
            return "failReason";
        }
        complaintService.deleteComplaint(complaint_id);
        List list = complaintService.getAll();
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
        model.addAttribute("list", complaintService.getAll());
        return "handleComplaintList";
    }


}
