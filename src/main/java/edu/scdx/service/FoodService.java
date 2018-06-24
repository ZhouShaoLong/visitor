package edu.scdx.service;

import edu.scdx.entity.Food;
import edu.scdx.entity.FoodDetail;
import edu.scdx.Utils.NetUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class FoodService {

    /**
     *  函数名：search
     *  描述： 查询输入城市的餐饮美食
     *  输入参数：
     *  String url  查询接口的url
     *  JSONObject json 查询的参数
     *  返回值：查询结果存储到List中
     */

    public List<Food> search(String url, JSONObject json) {
        List<Food> foods = new ArrayList<Food>();
        NetUtils netUtils = new NetUtils();
        try {
            JSONObject Result;
            Result = netUtils.get(url, json);
            if (Result.get("status").equals("1")) {
                JSONArray array = Result.getJSONArray("pois");
                if (array.length() != 0) {
                    JSONObject object = new JSONObject();
                    Food food;
                    for (int i = 0; i < array.length(); i++) {
                        object = array.getJSONObject(i);
                        food = new Food();
                        food.setId(object.getString("id"));
                        food.setName(object.getString("name"));
                        food.setAddress(object.getString("address"));
                        food.setLocation(object.getString("location"));
                        food.setTel(object.getString("tel"));
                        food.setPname(object.getString("pname"));
                        food.setCityname(object.getString("cityname"));
                        food.setAdname(object.getString("adname"));
                        foods.add(food);
                    }

                } else {
                    System.out.print("查询结果集为空");
                }

            } else {
                System.out.print("查询失败错误代码:" + Result.get("status") + "\n" + "错误信息:" + Result.get("info"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return foods;
    }

    /**
     *  函数名：foodDetail
     *  描述：根据餐饮美食店铺的id查询店铺的详细信息
     *  输入参数：
     *  String url  查询接口的url
     *  JSONObject json 查询的参数
     *  返回值：食物的详情类
     */

    public FoodDetail foodDetail(String url, JSONObject json) {
        NetUtils netUtils = new NetUtils();
        JSONObject Result = new JSONObject();
        FoodDetail foodDetail = new FoodDetail();
        try {
            Result = netUtils.get(url, json);
            if (Result.get("status").equals("1")) {
                JSONArray array = Result.getJSONArray("pois");
                if (array.length() != 0) {
                    JSONObject object = array.getJSONObject(0);
                    if (object.length() != 0) {
                        foodDetail.setId(object.getString("id"));
                        foodDetail.setName(object.getString("name"));
                        foodDetail.setType(object.getString("type"));
                        foodDetail.setTag(object.getString("tag"));
                        foodDetail.setOpen_time(object.getJSONObject("biz_ext").getString("open_time"));
                        foodDetail.setRecommend(object.getJSONObject("deep_info").getString("recommend"));
                        foodDetail.setIntro(object.getJSONObject("deep_info").getString("intro"));
                        foodDetail.setAddress(object.getString("address"));
                        foodDetail.setTel(object.getString("tel"));
                        foodDetail.setLocation(object.getString("location"));
                    }
                }


            } else {
                System.out.print("数据获取失败");
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return foodDetail;
    }

}
