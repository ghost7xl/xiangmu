package com.shopping.pojo;

public class OrderDetail {
    private int id;
    private int oid;
    private int gid;
    private int num;
    private double money;
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
	public OrderDetail(int id, int oid, int gid, int num, double money) {
		super();
		this.id = id;
		this.oid = oid;
		this.gid = gid;
		this.num = num;
		this.money = money;
	}
	public OrderDetail() {
		super();
	}
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", oid=" + oid + ", gid=" + gid
				+ ", num=" + num + ", money=" + money + "]";
	}
    
}
