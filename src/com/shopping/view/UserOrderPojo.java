package com.shopping.view;

import java.sql.Date;
import java.util.List;

public class UserOrderPojo {
	private int oid;
	private Date createtime;
	private String addressname;
	private String tel;
	private String address;
	private double allprice;
	private List<GoodsOrderDetailView> godvList;

	public UserOrderPojo() {
		super();
	}

	public UserOrderPojo(int oid, Date createtime, String addressname,
			String tel, String address, double allprice,
			List<GoodsOrderDetailView> godvList) {
		super();
		this.oid = oid;
		this.createtime = createtime;
		this.addressname = addressname;
		this.tel = tel;
		this.address = address;
		this.allprice = allprice;
		this.godvList = godvList;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getAddressname() {
		return addressname;
	}

	public void setAddressname(String addressname) {
		this.addressname = addressname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getAllprice() {
		return allprice;
	}

	public void setAllprice(double allprice) {
		this.allprice = allprice;
	}

	public List<GoodsOrderDetailView> getGodvList() {
		return godvList;
	}

	public void setGodvList(List<GoodsOrderDetailView> godvList) {
		this.godvList = godvList;
	}

	@Override
	public String toString() {
		return "UserOrderPojo [oid=" + oid + ", createtime=" + createtime
				+ ", addressname=" + addressname + ", tel=" + tel
				+ ", address=" + address + ", allprice=" + allprice
				+ ", godvList=" + godvList + "]";
	}

}
