package edu.scdx.controller;

import edu.scdx.entity.Hotel;
import edu.scdx.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Menfer on 2017/7/26.
 * HotelController
 * 酒店相关功能的URL映射
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    /**
     * 显示所有酒店列表
     * */
    @RequestMapping("/showAll")
    public String showAll(Model model, int page){
        List list = hotelService.getAll();
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
        return "hotelList";
    }

    /**
     * 搜索酒店
     * 参数：city 城市
     *       star 星级
     *       price 价格区间
     *       page 显示页
     * */
    @RequestMapping("/search")
    public String search(Model model,String city, int star, int price, int page){
        double minPrice=0, maxPrice=0;
        if(price == 1){
            minPrice = 0;
            maxPrice = 150;
        }
        if(price == 2){
            minPrice = 150;
            maxPrice = 300;
        }
        if(price == 3){
            minPrice = 300;
            maxPrice = 600;
        }
        if(price == 4) {
            minPrice = 600;
            maxPrice = 99999;
        }
        List list = hotelService.getSearchdResult(city,star,minPrice,maxPrice);
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
        model.addAttribute("selectedCity",city);
        model.addAttribute("selectedStar",star);
        model.addAttribute("selectedPrice",price);
        return "searchHotelList";
    }
}
