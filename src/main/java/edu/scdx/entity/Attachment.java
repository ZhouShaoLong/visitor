package edu.scdx.entity;

/**
 * Created by Menfer on 2017/7/24.
 */
public class Attachment {
    private int complaint_id;
    private String filename;
    private int type;

    public int getComplaint_id() {
        return complaint_id;
    }

    public void setComplaint_id(int complaint_id) {
        this.complaint_id = complaint_id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
