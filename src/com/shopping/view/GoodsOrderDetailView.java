package com.shopping.view;

import java.sql.Date;

public class GoodsOrderDetailView {
	private int id;
	private String picture;
	private String name;
	private int star;
	private Date pubdate;
	private double money;
	private int num;
	private double allmoney;

	public GoodsOrderDetailView() {
		super();
	}

	public GoodsOrderDetailView(int id, String picture, String name, int star,
			Date pubdate, double money, int num, double allmoney) {
		super();
		this.id = id;
		this.picture = picture;
		this.name = name;
		this.star = star;
		this.pubdate = pubdate;
		this.money = money;
		this.num = num;
		this.allmoney = allmoney;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public Date getPubdate() {
		return pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getAllmoney() {
		return allmoney;
	}

	public void setAllmoney(double allmoney) {
		this.allmoney = allmoney;
	}

	@Override
	public String toString() {
		return "GoodsOrderDetailView [id=" + id + ", picture=" + picture
				+ ", name=" + name + ", star=" + star + ", pubdate=" + pubdate
				+ ", money=" + money + ", num=" + num + ", allmoney="
				+ allmoney + "]";
	}

}
