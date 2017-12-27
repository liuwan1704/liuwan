package com.jnmd.liuwan.domain;

import java.util.List;

public class HotelPrice {
	private int hpid;
	private Province province;
	private HouseType houseType;
	private int city_id;
	private int house_id;
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
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public int getHouse_id() {
		return house_id;
	}
	public void setHouse_id(int house_id) {
		this.house_id = house_id;
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
	
	public HotelPrice(int hpid, int city_id, int house_id, double price, int area, int floor, char smoke, int peomax) {
		super();
		this.hpid = hpid;
		this.city_id = city_id;
		this.house_id = house_id;
		this.price = price;
		this.area = area;
		this.floor = floor;
		this.smoke = smoke;
		this.peomax = peomax;
	}
	public HotelPrice(int city_id, int house_id, double price, int area, int floor, char smoke, int peomax) {
		super();
		this.city_id = city_id;
		this.house_id = house_id;
		this.price = price;
		this.area = area;
		this.floor = floor;
		this.smoke = smoke;
		this.peomax = peomax;
	}
	public HotelPrice(int hpid, Province province, HouseType houseType, int city_id, int house_id, double price,
			int area, int floor, char smoke, int peomax, List<HousePic> housePic) {
		super();
		this.hpid = hpid;
		this.province = province;
		this.houseType = houseType;
		this.city_id = city_id;
		this.house_id = house_id;
		this.price = price;
		this.area = area;
		this.floor = floor;
		this.smoke = smoke;
		this.peomax = peomax;
		this.housePic = housePic;
	}
	public HotelPrice() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "HotelPrice [hpid=" + hpid + ", province=" + province + ", houseType=" + houseType + ", city_id="
				+ city_id + ", house_id=" + house_id + ", price=" + price + ", area=" + area + ", floor=" + floor
				+ ", smoke=" + smoke + ", peomax=" + peomax + ", housePic=" + housePic + "]";
	}
	
	
}
