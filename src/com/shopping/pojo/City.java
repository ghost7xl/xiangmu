package com.shopping.pojo;

public class City {
	private int id;
	private String name;
	private int pid;

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

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public City(int id, String name, int pid) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
	}

	public City() {
		super();
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", pid=" + pid + "]";
	}

}
