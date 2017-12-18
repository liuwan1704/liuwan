package com.jnmd.liuwan.controller.hotelController;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jnmd.liuwan.domain.Hotel;
import com.jnmd.liuwan.service.HotelService;


@Controller
@Scope("prototype")
public class HotelController {
	
	@Resource
	private HotelService hotelService;
	
	@RequestMapping("/getHotels")
	public ModelAndView getHotels(){
		List<Hotel> hotels = hotelService.getHotels();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hotelList");
		
		mv.addObject("hotels", hotels);
		return mv;
	}
}
