package com.jnmd.liuwan.domain;

public class HotelPic {
	private int pid;
	private String picPath;
	private Hotel hotel;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public HotelPic() {
		super();
	}
	public HotelPic(int pid, String picPath, Hotel hotel) {
		super();
		this.pid = pid;
		this.picPath = picPath;
		this.hotel = hotel;
	}
	@Override
	public String toString() {
		return "HotelPic [pid=" + pid + ", picPath=" + picPath + ", hotel=" + hotel + "]";
	}
	
}
