package com.shopping.pojo;

public class County {
	private int id;
	private String name;
	private String weatherCode;
	private int cityid;

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

	public String getWeatherCode() {
		return weatherCode;
	}

	public void setWeatherCode(String weatherCode) {
		this.weatherCode = weatherCode;
	}

	public int getCityid() {
		return cityid;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
	}

	public County(int id, String name, String weatherCode, int cityid) {
		super();
		this.id = id;
		this.name = name;
		this.weatherCode = weatherCode;
		this.cityid = cityid;
	}

	public County() {
		super();
	}

	@Override
	public String toString() {
		return "County [id=" + id + ", name=" + name + ", weatherCode="
				+ weatherCode + ", cityid=" + cityid + "]";
	}

}
