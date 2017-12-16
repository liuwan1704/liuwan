package com.jnmd.liuwan.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jnmd.liuwan.service.HotelService;


@Controller
@Scope("prototype")
public class HotelController {
	
	@Resource
	private HotelService hotelService;
	
}
