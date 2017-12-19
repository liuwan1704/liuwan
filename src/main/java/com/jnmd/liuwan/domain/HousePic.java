package com.jnmd.liuwan.domain;

public class HousePic {
	private int hpid;
	private String picPath;
	private HotelPrice hotelPrice;
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
	public HotelPrice getHousePrice() {
		return hotelPrice;
	}
	public void setHousePrice(HotelPrice hotelPrice) {
		this.hotelPrice = hotelPrice;
	}
	public HousePic() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HousePic(int hpid, String picPath, HotelPrice housePrice) {
		super();
		this.hpid = hpid;
		this.picPath = picPath;
		this.hotelPrice = housePrice;
	}
	@Override
	public String toString() {
		return "HousePic [hpid=" + hpid + ", picPath=" + picPath + ", housePrice=" + hotelPrice + "]";
	}
	
}
