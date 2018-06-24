package edu.scdx.service;

import edu.scdx.dao.AttachmentDao;
import edu.scdx.dao.ComplaintDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Menfer on 2017/7/24.
 */

@Component
public class AttachmentService {
    @Autowired
    private AttachmentDao attachmentDao;

    @Autowired
    private ComplaintDao complaintDao;

    /**
     *  函数名：addAttachment
     *  描述：添加附件
     *  输入参数：
     *      String filename 文件名
     *      int type    文件的类型：0图片 1视频
     *  返回值：无
     */

    public void addAttachment(String filename, int type){
        int newId = complaintDao.getMaxId();
        attachmentDao.addAttachment(newId, filename, type);
    }

    /**
     *  函数名：getFromComplaintId
     *  描述：根据ID获取投诉的所有附件
     *  输入参数：
     *      int complaint_id    投诉的id
     *  返回值：附件列表
     */

    public List getFromComplaintId(int complaint_id){
        return attachmentDao.getFromComplaintId(complaint_id);
    }

}
