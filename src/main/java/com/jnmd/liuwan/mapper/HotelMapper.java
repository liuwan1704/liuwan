package com.jnmd.liuwan.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jnmd.liuwan.domain.Hotel;
import com.jnmd.liuwan.domain.HotelMid;
import com.jnmd.liuwan.domain.HotelPic;
import com.jnmd.liuwan.domain.HotelPrice;
import com.jnmd.liuwan.domain.Recommend;

@Repository
public interface HotelMapper {
	public List<Hotel> getHotels(Map<String,Object> map);
	public int maxNum();
	public List<HotelPrice> getAllHouse(Map<String,Object> map);
	public void deleteHouse(Map<String,Object> map);
	public void deleteMidByPid(Map<String,Object> map);
	public void deleteHotel(Map<String,Object> map);
	
	public Hotel getHotel(int hid);
	public void updateHotelId(Hotel hotel);
	public HotelPrice getHouse(int hpid);
	public void updateHouse(HotelPrice hotelPrice);
	
	
	public List<Recommend> getRec();
	public List<Recommend> getDec();
	public Recommend findID(Map<String,Object> map);
	public void delete(int rid);
	public void updateRec(Map<String,Object> map);
	
	public Recommend getRecommend(int rid);
	
	public void saveRecommend(Recommend recommend);
	
	
	
	
	
	
	
	
	public void addHotel(Hotel hotel);
	public void addHotelPic(Map<String,Object> map);
	
	public void saveMid(Map<String,Integer> map);
	public void saveHouse(Map<String,Object> map);
	
	
	public int maxId();
	public void saveHousePic(Map<String,Object> map);
	
	public void updateHousePic(Map<String, Object> map);
}
