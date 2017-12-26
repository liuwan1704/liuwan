package com.jnmd.liuwan.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.omg.CORBA.UserException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jnmd.liuwan.domain.Hotel;
import com.jnmd.liuwan.domain.HotelMid;
import com.jnmd.liuwan.domain.HotelPic;
import com.jnmd.liuwan.domain.HotelPrice;
import com.jnmd.liuwan.exception.HotelException;
import com.jnmd.liuwan.mapper.HotelMapper;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class HotelService{
	@Resource
	private HotelMapper hotelMapper;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Hotel> getHotels(Map<String,Object> map){
		return hotelMapper.getHotels(map);
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public int maxNum(){
		return hotelMapper.maxNum();
	}
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<HotelPrice> getAllHouse(Map<String,Object> map){
		return hotelMapper.getAllHouse(map);
	}
	
	@Transactional(rollbackFor=HotelException.class)
	public void deleteHouse(Map<String,Object> map){
		hotelMapper.deleteHouse(map);
	}
	@Transactional(rollbackFor=HotelException.class)
	public void deleteMidByPid(Map<String,Object> map){
		hotelMapper.deleteMidByPid(map);
	}
	@Transactional(rollbackFor=HotelException.class)
	public void deleteHotel(Map<String,Object> map){
		hotelMapper.deleteHotel(map);
	}
	@Transactional(rollbackFor=HotelException.class)
	public void addHotel(Hotel hotel){
		hotelMapper.addHotel(hotel);
	}
	@Transactional(rollbackFor=HotelException.class)
	public void addHotelPic(Map<String , Object> map){
		hotelMapper.addHotelPic(map);
	}
	@Transactional(propagation=Propagation.SUPPORTS)
	public void updateHotel(Hotel hotel){
		hotelMapper.updateHotel(hotel);
	}
	@Transactional(propagation=Propagation.SUPPORTS)
	public Hotel getHotel(int hid){
		return hotelMapper.getHotel(hid);
	}
	@Transactional(propagation=Propagation.SUPPORTS)
	public void deleteAHotelPic(Map<String,Object> map){
		hotelMapper.deleteAHotelPicByPath(map);
	}
}
