package com.jnmd.liuwan.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jnmd.liuwan.domain.Hotel;
import com.jnmd.liuwan.domain.HotelPrice;

@Repository
public interface HotelMapper {
	public List<Hotel> getHotels(Map<String,Object> map);
	public int maxNum();
	public List<HotelPrice> getAllHouse(Map<String,Object> map);
	public void deleteHouse(Map<String,Object> map);
	public void deleteMidByPid(Map<String,Object> map);
	public void deleteHotel(Map<String,Object> map);
	public void addHotel(Hotel hotel);
	public void addHotelPic(Map<String,Object> map);
	public void updateHotel(Hotel hotel);
	public Hotel getHotel(int hid);
	public void deleteAHotelPicByPath(Map<String,Object> map);
}
