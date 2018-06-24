package edu.scdx.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import edu.scdx.Utils.SessionUtils;
import edu.scdx.entity.Admin;
import edu.scdx.service.RoomService;
import edu.scdx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Menfer on 2017/7/22.
 * RoomController
 * 酒店房间信息的URL映射
 */
@Controller
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    /**
     * 修改房间信息
     * 参数：price 价格
     *      orderStatus 是否被预定
     *      startTime 预定开始时间
     *      endTime 预定结束时间
     *      hotel_id 酒店ID
     *      room_num 房间号
     * */
    @RequestMapping("/editInfo")
    public String editRoom(Model model, double price, int orderStatus, String startTime, String endTime, int hotel_id, String room_num){
        HttpSession session = SessionUtils.getCurrentSession();
        if(session.getAttribute("admin")==null){
            String failMessage;
            failMessage = "只有管理员可以执行此操作，如果您是管理员，请先登录。";
            model.addAttribute("failmessage",failMessage);
            return "failReason";
        }
        roomService.updateRoomInfo(price,orderStatus,startTime,endTime,hotel_id,room_num);
        List list = roomService.getRoomFromId(hotel_id);
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
        model.addAttribute("list", list);
        model.addAttribute("hotel_id",hotel_id);
        return "hotelRoomList";
    }

    /**
     * 显示一个酒店的所有房间
     * 参数：hotel_id 酒店ID
     *       page 显示的页
     * */
    @RequestMapping("/toRoomList")
    public String toRoomList(Model model, int hotel_id, int page){
        HttpSession session = SessionUtils.getCurrentSession();
        Admin admin = (Admin) (session.getAttribute("admin"));
        if(admin == null){
            String failMessage;
            failMessage = "只有管理员可以执行此操作，如果您是管理员，请先登录。";
            model.addAttribute("failmessage",failMessage);
            return "failReason";
        }
        List list = roomService.getRoomFromId(hotel_id);
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
        model.addAttribute("list", list);
        model.addAttribute("hotel_id",hotel_id);
        return "hotelRoomList";
    }
}
