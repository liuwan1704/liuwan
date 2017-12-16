package com.jnmd.liuwan.domain;

public class HousePic {
	private int hpid;
	private String picPath;
	private HousePic housePrice;
	public int getHpid() {
		return hpid;
	}
	public void setHpid(int hpid) {
		this.hpid = hpid;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public HousePic getHousePrice() {
		return housePrice;
	}
	public void setHousePrice(HousePic housePrice) {
		this.housePrice = housePrice;
	}
	public HousePic() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HousePic(int hpid, String picPath, HousePic housePrice) {
		super();
		this.hpid = hpid;
		this.picPath = picPath;
		this.housePrice = housePrice;
	}
	@Override
	public String toString() {
		return "HousePic [hpid=" + hpid + ", picPath=" + picPath + ", housePrice=" + housePrice + "]";
	}
	
}
