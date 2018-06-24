package edu.scdx.controller;

import edu.scdx.entity.Food;
import edu.scdx.service.FoodService;
import edu.scdx.Utils.NetUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Menfer on 2017/7/22.
 *FoodController
 * 与美食搜索有关的URL映射
 */

@Controller
@RequestMapping("/food")
public class FoodController {
    @Autowired
    public FoodService foodService;

    /**
     * 搜索美食
     * 参数: city 城市名
     * */
    @RequestMapping("/search.do")
    public String search(Model model,String city) {
        try {
            JSONObject json = new JSONObject();
            String url = "http://restapi.amap.com/v3/place/text?";
            json.put("key", "9eaf0d96bbaf7ba58c7b921f02ef09ff");
            json.put("keywords", "美食");
            json.put("types", "餐饮服务");
            json.put("city", city);
            json.put("citylimit", "true");
            json.put("children", "1");
            json.put("offset", "20");
            json.put("output", "json");
            List<Food> foodList = foodService.search(url,json);
            model.addAttribute("foodList",foodList);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "foodList";
    }

    /**
     * 显示美食细节
     * 参数： id 美食ID
     * */
    @RequestMapping("/detail.do")
    public String foodDetail(Model model,String id){
        try{
            JSONObject json = new JSONObject();
            String url = "http://restapi.amap.com/v3/place/detail";
            json.put("key","9eaf0d96bbaf7ba58c7b921f02ef09ff");
            json.put("output","json");
            json.put("id",id);

            model.addAttribute("detail",foodService.foodDetail(url,json));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return "foodDetail";
    }


}
