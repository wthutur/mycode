package cn.huaguang.pojo;
/**
 * 
 * @功能：公告实现类
 * @author yangxin
 * @date 2020年8月15日
 * @version jdk 1.8
 */
public class Notice {
	private String id;
	private String notice_title;
	private String notice_msg;
	private String notice_content;
	private String upload_time;
	private String remark;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_msg() {
		return notice_msg;
	}
	public void setNotice_msg(String notice_msg) {
		this.notice_msg = notice_msg;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public String getUpload_time() {
		return upload_time;
	}
	public void setUpload_time(String upload_time) {
		this.upload_time = upload_time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Notice(String id, String upload_name, String notice_title, String notice_msg, String notice_content,
			String upload_time, String remark) {
		super();
		this.id = id;
		this.notice_title = notice_title;
		this.notice_msg = notice_msg;
		this.notice_content = notice_content;
		this.upload_time = upload_time;
		this.remark = remark;
	}
	public Notice() {
		super();
	}
	@Override
	public String toString() {
		return "Notice [id=" + id + ", upload_name=" + notice_title + ", notice_msg="
				+ notice_msg + ", notice_content=" + notice_content + ", upload_time=" + upload_time + ", remark="
				+ remark + "]";
	}
	

}
