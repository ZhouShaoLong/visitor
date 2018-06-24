package edu.scdx.entity;

import java.util.Date;

/**
 * Created by Menfer on 2017/7/24.
 */
public class Performance {
    private int performance_id;
    private String title;
    private String type;
    private String groupName;
    private String startTime;
    private String endTime;
    private String intro;
    private double price;

    public int getPerformance_id() {
        return performance_id;
    }

    public void setPerformance_id(int performance_id) {
        this.performance_id = performance_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
