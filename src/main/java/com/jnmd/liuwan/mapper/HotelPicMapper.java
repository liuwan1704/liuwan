package com.jnmd.liuwan.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.jnmd.liuwan.domain.HotelPic;

@Repository
public interface HotelPicMapper {
	public List<HotelPic> getHotelPicList(int hid);
}

