package com.jnmd.liuwan.domain;

import java.util.List;

public class Hotel {
	private int hid;
	private String name;
	private String contact;
	private String address;
	private String feature;
	private int level;
	private String serverDesc;
	private String intime;
	private String outtime;
	private List<HotelMid> hotelMids;
	private List<HotelPic> hotelPics;
	
	public String getIntime() {
		return intime;
	}
	public void setIntime(String intime) {
		this.intime = intime;
	}
	public String getOuttime() {
		return outtime;
	}
	public void setOuttime(String outtime) {
		this.outtime = outtime;
	}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getServerDesc() {
		return serverDesc;
	}
	public void setServerDesc(String serverDesc) {
		this.serverDesc = serverDesc;
	}
	public List<HotelMid> getHotelMids() {
		return hotelMids;
	}
	public void setHotelMids(List<HotelMid> hotelMids) {
		this.hotelMids = hotelMids;
	}
	public List<HotelPic> getHotelPics() {
		return hotelPics;
	}
	public void setHotelPics(List<HotelPic> hotelPics) {
		this.hotelPics = hotelPics;
	}
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hotel(int hid, String name, String contact, String address, String feature, int level, String serverDesc,
			List<HotelMid> hotelMids, List<HotelPic> hotelPics) {
		super();
		this.hid = hid;
		this.name = name;
		this.contact = contact;
		this.address = address;
		this.feature = feature;
		this.level = level;
		this.serverDesc = serverDesc;
		this.hotelMids = hotelMids;
		this.hotelPics = hotelPics;
	}
	@Override
	public String toString() {
		return "Hotel [hid=" + hid + ", name=" + name + ", contact=" + contact + ", address=" + address + ", feature="
				+ feature + ", level=" + level + ", serverDesc=" + serverDesc + ", hotelMids=" + hotelMids
				+ ", hotelPics=" + hotelPics + "]";
	}
	
}
