package com.jnmd.liuwan.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jnmd.liuwan.domain.Hotel;
import com.jnmd.liuwan.domain.HotelPrice;
import com.jnmd.liuwan.domain.Province;
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
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Province> getCityList(){
		return hotelMapper.getCityList();
	}
	
	@Transactional(rollbackFor=HotelException.class)
	public void addAHouse(HotelPrice house){
		hotelMapper.addAHouse(house);
	}
	@Transactional(rollbackFor=HotelException.class)
	public void addHotelMid(Map<String,Object> map){
		hotelMapper.addHotelMid(map);
	}
	@Transactional(rollbackFor=HotelException.class)
	public void addHousePic(Map<String,Object> map){
		hotelMapper.addHousePic(map);
	}
	@Transactional(propagation=Propagation.SUPPORTS)
	public void updateHousePic(Map<String,Object> map){
		hotelMapper.updateHousePic(map);
	}
	@Transactional(propagation=Propagation.SUPPORTS)
	public void updateHouseMessage(HotelPrice house){
		hotelMapper.updateHouseMessage(house);
	}
	@Transactional(propagation=Propagation.SUPPORTS)
	public HotelPrice getAHouse(int hpid){
		return hotelMapper.getAHouseById(hpid);
	}
}
