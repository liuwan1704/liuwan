package com.jnmd.liuwan.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jnmd.liuwan.domain.Hotel;
import com.jnmd.liuwan.domain.HotelPic;

@Repository
public interface HotelMapper {
	public List<Hotel> getHotels(Map<String,Object> map);
	public int maxNum();
}
