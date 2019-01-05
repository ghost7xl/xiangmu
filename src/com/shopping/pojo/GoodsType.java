package com.shopping.pojo;

public class GoodsType {
	private int id;
	private String name;
	private int level;
	private int parentid;
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

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public GoodsType(int id, String name, int level, int parentid, int flag) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.parentid = parentid;
		this.flag = flag;
	}

	public GoodsType() {
		super();
	}

	@Override
	public String toString() {
		return "goodstype [id=" + id + ", name=" + name + ", level=" + level
				+ ", parentid=" + parentid + ", flag=" + flag + "]";
	}

}
