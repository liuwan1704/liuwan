package com.jnmd.liuwan.domain;

import java.util.List;

public class HotelPrice {
	private int hpid;
	private Province province;
	private HouseType houseType;
	private double price;
	private int area;
	private int floor;
	private char smoke;
	private int peomax;
	private List<HousePic> housePic;
	public int getHpid() {
		return hpid;
	}
	public void setHpid(int hpid) {
		this.hpid = hpid;
	}
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	public HouseType getHouseType() {
		return houseType;
	}
	public void setHouseType(HouseType houseType) {
		this.houseType = houseType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public char getSmoke() {
		return smoke;
	}
	public void setSmoke(char smoke) {
		this.smoke = smoke;
	}
	public int getPeomax() {
		return peomax;
	}
	public void setPeomax(int peomax) {
		this.peomax = peomax;
	}
	public List<HousePic> getHousePic() {
		return housePic;
	}
	public void setHousePic(List<HousePic> housePic) {
		this.housePic = housePic;
	}
	public HotelPrice() {
		super();
	}
	public HotelPrice(int hpid, Province province, HouseType houseType, double price, int area, int floor, char smoke,
			int peomax, List<HousePic> housePic) {
		super();
		this.hpid = hpid;
		this.province = province;
		this.houseType = houseType;
		this.price = price;
		this.area = area;
		this.floor = floor;
		this.smoke = smoke;
		this.peomax = peomax;
		this.housePic = housePic;
	}
	@Override
	public String toString() {
		return "HotelPrice [hpid=" + hpid + ", province=" + province + ", houseType=" + houseType + ", price=" + price
				+ ", area=" + area + ", floor=" + floor + ", smoke=" + smoke + ", peomax=" + peomax + ", housePic="
				+ housePic + "]";
	}
	
	
}
