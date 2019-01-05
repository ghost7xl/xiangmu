package com.shopping.pojo;

public class UserAddress {
	private int id ;
	private String name;
	private String phone;
	private int pid;
	private int cityid;
	private int countyid;
	private int uid;
	private String detail;
	private int flag;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getCityid() {
		return cityid;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	public int getCountyid() {
		return countyid;
	}
	public void setCountyid(int countyid) {
		this.countyid = countyid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public UserAddress(int id, String name, String phone, int pid, int cityid,
			int countyid, int uid, String detail, int flag) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.pid = pid;
		this.cityid = cityid;
		this.countyid = countyid;
		this.uid = uid;
		this.detail = detail;
		this.flag = flag;
	}
	public UserAddress() {
		super();
	}
	@Override
	public String toString() {
		return "UserAddress [id=" + id + ", name=" + name + ", phone=" + phone
				+ ", pid=" + pid + ", cityid=" + cityid + ", countyid="
				+ countyid + ", uid=" + uid + ", detail=" + detail + ", flag="
				+ flag + "]";
	}
	
    
}
