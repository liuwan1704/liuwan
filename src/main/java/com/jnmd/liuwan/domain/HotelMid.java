package com.jnmd.liuwan.domain;

import java.util.List;

public class HotelMid {
	private int mid;
	private List<HotelPrice> hotelPrice;
	private Hotel hotel;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public List<HotelPrice> getHotelPrice() {
		return hotelPrice;
	}
	public void setHotelPrice(List<HotelPrice> hotelPrice) {
		this.hotelPrice = hotelPrice;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public HotelMid() {
		super();
	}
	public HotelMid(int mid, List<HotelPrice> hotelPrice, Hotel hotel) {
		super();
		this.mid = mid;
		this.hotelPrice = hotelPrice;
		this.hotel = hotel;
	}
	@Override
	public String toString() {
		return "HotelMid [mid=" + mid + ", hotelPrice=" + hotelPrice + ", hotel=" + hotel + "]";
	}
	
}
