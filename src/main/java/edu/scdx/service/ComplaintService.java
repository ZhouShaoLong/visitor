package edu.scdx.service;

import edu.scdx.dao.ComplaintDao;
import edu.scdx.dao.UserDao;
import edu.scdx.entity.Complaint;
import edu.scdx.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import java.util.Date;
import java.util.List;

/**
 * Created by Menfer on 2017/7/22.
 */
@Component
public class ComplaintService {
    @Autowired
    private ComplaintDao complaintDao;
    @Autowired
    private UserDao userDao;

    public List getAll() {
        return complaintDao.getAll();
    }

    /**
     * 函数名：addComplaint
     * 描述：添加投诉
     * 输入参数：
     * String title    投诉的标题
     * int userId      投诉用户的id
     * String content  投诉的正文
     * int handleStatus    是否回复    0没有回复 1以回复
     * int checkStatus     是否通过审核 0未通过审核 1以通过审核
     * int star        评价的星级1-5星
     * String judge    用户回复的评价内容
     * 返回值：
     */
    public void addComplaint(String title, int userId, String content, int handleStatus, int checkStatus, int star, String judge) {
        complaintDao.addComplaint(title, userId, content, handleStatus, checkStatus, star, judge);
    }

    /**
     * 函数名：replyComplaint
     * 描述：回复投诉
     * 输入参数：
     * String reply 回复的内容
     * int id       投诉的id
     * 返回值：无
     */
    public void replyComplaint(String reply, int id) {
        complaintDao.updateReplyById(reply, id);
    }

    /**
     *  函数名：checkComplaint
     *  描述：审核投诉
     *  输入参数：
     *  int checkStatus 投诉审核的状态
     *  int id      投诉的id
     *  返回值：无
     */
    public void checkComplaint(int checkStatus, int id) {
        complaintDao.updateCheckStatus(checkStatus, id);
    }

    /**
     *  函数名：judgeComplaint
     *  描述：评价投诉
     *  输入参数：
     *  int star    评价星级
     *  String judge    评价内容
     *  int id      投诉的id
     *  返回值：
     */
    public void judgeComplaint(int star, String judge, int id) {
        complaintDao.judgeComplaint(star, judge, id);
    }

    /**
     *  函数名：getUserFromId
     *  描述：获取投诉人的昵称
     *  输入参数：
     *  int id  投诉人的id
     *  返回值：User信息
     */
    public User getUserFromId(int id) {
        return userDao.getUserFromId(id);
    }

    /**
     *  函数名：getComplaintFromId
     *  描述：获取投诉
     *  输入参数：
     *  int complaint_id    投诉的id
     *  返回值：
     */
    public Complaint getComplaintFromId(int complaint_id) {
        return complaintDao.getComplaintFromId(complaint_id);
    }

    /**
     *  函数名：getUserIdFromComplaintId
     *  描述：通过投诉ID获取投诉人的id
     *  输入参数：
     *  int complaint_id    投诉的id
     *  返回值：投诉人的id
     */
    public int getUserIdFromComplaintId(int complaint_id) {
        return complaintDao.getUserIdFromComplaintId(complaint_id);
    }

    /**
     *  函数名：getAllPublic
     *  描述：获取普通用户可见的投诉列表，即审批通过的投诉列表
     *  输入参数：无
     *  返回值：所有通过审核的投诉
     */
    public List getAllPublic() {
        return complaintDao.getComplaintFromCheckStatus(1);
    }

    /**
     *  函数名：deleteComplaint
     *  描述：删除投诉
     *  输入参数：
     *  int id  投诉的id
     *  返回值：无
     */
    public void deleteComplaint(int id) {
        complaintDao.deleteById(id);
    }

    /**
     *  函数名：getComplaintByUserId
     *  描述：获取特定用户的投诉
     *  输入参数：
     *  int userId  用户的id
     *  返回值：这个用户的所有投诉
     */
    public List getComplaintByUserId(int userId) {
        return complaintDao.getComplaintFromUserId(userId);
    }

    /**
     *  函数名：getUnHandledComplaintFromUserId
     *  描述：获取特定用户未处理投诉
     *  输入参数：
     *  int userId  用户的id
     *  返回值：当前用户所有的未处理的投诉
     */
    public List getUnHandledComplaintFromUserId(int userId) {
        return complaintDao.getComplaintFromHandleStatusAndId(0, userId);
    }

    /**
     *  函数名：getHandledComplaintFromUserId
     *  描述：获取特定用户已处理投诉
     *  输入参数：
     *  int userId  用户的id
     *  返回值：当前用户所有的以处理的投诉
     */
    public List getHandledComplaintFromUserId(int userId) {
        return complaintDao.getComplaintFromHandleStatusAndId(1, userId);
    }
}
