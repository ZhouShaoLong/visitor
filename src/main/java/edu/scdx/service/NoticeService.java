package edu.scdx.service;

import edu.scdx.dao.NoticeDao;
import edu.scdx.entity.Admin;
import edu.scdx.entity.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NoticeService {
    @Autowired
    private NoticeDao noticeDao;

    /**
     *  函数名：Publish
     *  描述：发布旅游应急信息
     *  输入参数：
     *  String title    应急信息标题
     *  int id          应急信息发个人id
     *  String content  应急信息正文
     *  String endtime  应急信息最终时间
     *  返回值：发布信息状态
     */

    public String Publish(String title,int id,String content,String endtime){
        if(noticeDao.Publish(content,id,title,endtime)){
            return "发布成功";
        }else {
            return "发布失败";
        }
    }

    /**
     *  函数名：getNoticeList
     *  描述：获取应急信息列表
     *  输入参数：无
     *  返回值：应急信息列表
     */

    public List<Notice> getNoticeList(){
        List<Notice> list = noticeDao.getNoticeList();
        return list;
    }

    /**
     *  函数名：getDetailById
     *  描述：获取应急信息详情
     *  输入参数：应急信息的id
     *  返回值：应急信息的详情
     */

    public Notice getDetailById(int id){
        Notice notice = noticeDao.getDetailById(id);
        return notice;
    }

    /**
     *  函数名：getAdminNameById
     *  描述：通过管理员的ID获取管理员的名字
     *  输入参数：
     *  int  id 管理员的ID
     *  返回值：管理员的名字
     */

    public String getAdminNameById(int id){
        Admin admin = noticeDao.getAdminNameById(id);
        String name = "";
        if (admin!=null){
            name = admin.getName();
        }
        return name;
    }

    /**
     *  函数名：deleteNoticeById
     *  描述：删除应急信息
     *  输入参数：应急信息的id
     *  返回值：删除是否成功的布尔值
     */

    public boolean deleteNoticeById(int id){
        boolean status = noticeDao.deleteNoticeById(id);
        return status;
    }

    /**
     *  函数名：insertModify
     *  描述：修改应急信息系
     *  输入参数：
     *  int id      应急信息原本的id
     *  String title    应急信息修改后的标题
     *  String content  应急信息修改后的内容
     *  String endtime  应急信息修改后的结束时间
     *  返回值：修改是否成功的布尔值
     */

    public boolean insertModify(int id,String title,String content,String endtime){
        boolean status = noticeDao.insertModify(id,title,content,endtime);
        return status;
    }

}
