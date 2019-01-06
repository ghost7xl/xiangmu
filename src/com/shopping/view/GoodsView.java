package com.shopping.view;

import java.sql.Date;

public class GoodsView {
	private int typeid;
	private String typename;
	private int level;
	private int parentid;
	private int typeflag;
	private int goodsid;
	private String goodsname;
	private Double goodsprice;
	private Date goodspubdate;
	private String goodsintro;
	private String picture;
	private int goodsstar;
	private int goodsflag;
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public int getTypeflag() {
		return typeflag;
	}
	public void setTypeflag(int typeflag) {
		this.typeflag = typeflag;
	}
	public int getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public Double getGoodsprice() {
		return goodsprice;
	}
	public void setGoodsprice(Double goodsprice) {
		this.goodsprice = goodsprice;
	}
	public Date getGoodspubdate() {
		return goodspubdate;
	}
	public void setGoodspubdate(Date goodspubdate) {
		this.goodspubdate = goodspubdate;
	}
	public String getGoodsintro() {
		return goodsintro;
	}
	public void setGoodsintro(String goodsintro) {
		this.goodsintro = goodsintro;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getGoodsstar() {
		return goodsstar;
	}
	public void setGoodsstar(int goodsstar) {
		this.goodsstar = goodsstar;
	}
	public int getGoodsflag() {
		return goodsflag;
	}
	public void setGoodsflag(int goodsflag) {
		this.goodsflag = goodsflag;
	}
	@Override
	public String toString() {
		return "GoodsView [typeid=" + typeid + ", typename=" + typename
				+ ", level=" + level + ", parentid=" + parentid + ", typeflag="
				+ typeflag + ", goodsid=" + goodsid + ", goodsname="
				+ goodsname + ", goodsprice=" + goodsprice + ", goodspubdate="
				+ goodspubdate + ", goodsintro=" + goodsintro + ", picture="
				+ picture + ", goodsstar=" + goodsstar + ", goodsflag="
				+ goodsflag + "]";
	}
	public GoodsView(int typeid, String typename, int level, int parentid,
			int typeflag, int goodsid, String goodsname, Double goodsprice,
			Date goodspubdate, String goodsintro, String picture,
			int goodsstar, int goodsflag) {
		super();
		this.typeid = typeid;
		this.typename = typename;
		this.level = level;
		this.parentid = parentid;
		this.typeflag = typeflag;
		this.goodsid = goodsid;
		this.goodsname = goodsname;
		this.goodsprice = goodsprice;
		this.goodspubdate = goodspubdate;
		this.goodsintro = goodsintro;
		this.picture = picture;
		this.goodsstar = goodsstar;
		this.goodsflag = goodsflag;
	}
	public GoodsView() {
		super();
	}
	
}
