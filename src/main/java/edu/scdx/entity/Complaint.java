package edu.scdx.entity;
import edu.scdx.dao.UserDao;
import edu.scdx.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by Menfer on 2017/7/22.
 */
public class Complaint {

    @Autowired
    private UserDao userDao;

    private int id;
    private String title;
    private int userId;
    private String content;
    private int handleStatus;
    private int checkStatus;
    private int star;
    private String judge;
    private String setTime;
    private String handleTime;
    private String checkTime;
    private String reply;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(int handleStatus) {
        this.handleStatus = handleStatus;
    }

    public int getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(int checkStatus) {
        this.checkStatus = checkStatus;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }

    public String getSetTime() {
        return setTime;
    }

    public void setSetTime(String setTime) {
        this.setTime = setTime;
    }

    public String getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(String handleTime) {
        this.handleTime = handleTime;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
    
}
