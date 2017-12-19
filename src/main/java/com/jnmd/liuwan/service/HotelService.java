package com.jnmd.liuwan.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jnmd.liuwan.domain.Hotel;
import com.jnmd.liuwan.domain.HotelPic;
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
	
	
	
}
