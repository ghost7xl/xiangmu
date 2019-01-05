package com.shopping.pojo;

import java.sql.Date;

public class User {
	private int id ;
	private String username ;
	private String password ;
	private String email;
	private String activatecode;
	private int flag;
	private String gender;
	private Date createtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getActivatecode() {
		return activatecode;
	}
	public void setActivatecode(String activatecode) {
		this.activatecode = activatecode;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public User(int id, String username, String password, String email,
			String activatecode, int flag, String gender, Date createtime) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.activatecode = activatecode;
		this.flag = flag;
		this.gender = gender;
		this.createtime = createtime;
	}
	public User() {
		super();
	}
	
	public User(String username, String password, String email, String gender) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "user [id=" + id + ", username=" + username + ", password="
				+ password + ", email=" + email + ", activatecode="
				+ activatecode + ", flag=" + flag + ", gender=" + gender
				+ ", createtime=" + createtime + "]";
	}
	

}
