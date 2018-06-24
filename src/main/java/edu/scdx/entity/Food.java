package edu.scdx.entity;

public class Food {
    private String id;
    private String name;
    private String address;
    private String location;
    private String tel;
    private String pname;
    private String cityname;
    private String adname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname;
    }
}


/*
      "id": "B001C8N59L",
      "name": "豪尚豪牛排馆(华阳店)",
      "type": "餐饮服务;外国餐厅;西餐厅(综合风味)",
      "typecode": "050201",
      "biz_type": "diner",
      "address": "华阳正西街43号2楼201号缤纷广场",
      "location": "104.053307,30.505953",
      "tel": "028-85638982;15957372454",
      "distance": [],
      "biz_ext": [],
      "pname": "四川省",
      "cityname": "成都市",
      "adname": "双流区",
      "importance": [],
      "shopid": [],
      "shopinfo": "0",
      "poiweight": []

        NetUtils netUtil = new NetUtils();
        JSONObject json = new JSONObject();
        json.element("key","da8282e6726f9c2aa521ae5ebc631a89");
        json.element("keywords","美食");
        json.element("types","050000");
        json.element("city","510116");
        json.element("citylimit","true");
        json.element("children","1");
        json.element("offset","20");
        json.element("output","json");



 */