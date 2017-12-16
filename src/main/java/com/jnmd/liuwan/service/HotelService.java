package com.jnmd.liuwan.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jnmd.liuwan.mapper.HotelMapper;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class HotelService {
	@Resource
	private HotelMapper hotelMapper;
}
