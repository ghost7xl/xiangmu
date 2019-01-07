package com.shopping.view;

import java.sql.Date;

public class OrderView {
	private int id;
	private int oid;
	private int uid;
	private String username;
	private int uaid;
	private int gid;
	private int num;
	private double money;
	private Date createTime;
	private int flag;

	public OrderView() {
		super();
	}

	public OrderView(int id, int oid, int uid, String username, int uaid,
			int gid, int num, double money, Date createTime, int flag) {
		super();
		this.id = id;
		this.oid = oid;
		this.uid = uid;
		this.username = username;
		this.uaid = uaid;
		this.gid = gid;
		this.num = num;
		this.money = money;
		this.createTime = createTime;
		this.flag = flag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getUaid() {
		return uaid;
	}

	public void setUaid(int uaid) {
		this.uaid = uaid;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "OrderView [id=" + id + ", oid=" + oid + ", uid=" + uid
				+ ", username=" + username + ", uaid=" + uaid + ", gid=" + gid
				+ ", num=" + num + ", money=" + money + ", createTime="
				+ createTime + ", flag=" + flag + "]";
	}

}
