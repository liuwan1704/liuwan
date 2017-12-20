package com.jnmd.liuwan.controller.hotelController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jnmd.liuwan.domain.Hotel;
import com.jnmd.liuwan.domain.HotelMid;
import com.jnmd.liuwan.domain.HotelPic;
import com.jnmd.liuwan.domain.HotelPrice;
import com.jnmd.liuwan.service.HotelService;


@Controller
@Scope("prototype")
public class HotelController {
	
	@Resource
	private HotelService hotelService;
	
	@RequestMapping("/getHotels")
	public ModelAndView getHotels(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		int start = (pageNum-1)*5;
		map.put("start",start);  
        map.put("pagesize",5);
		List<Hotel> hotels = hotelService.getHotels(map);
		int maxNum = hotelService.maxNum();
		int pageMax = (int)(Math.ceil(maxNum*1.0/5));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hotelList");
		mv.addObject("hotels", hotels);
		mv.addObject("pageNum",pageNum);
		mv.addObject("pageMax", pageMax);
		return mv;
	}
	
	@RequestMapping("/getAllHouse")
	public ModelAndView getAllHouse(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		int hid = Integer.parseInt(request.getParameter("hid"));
		map.put("hid", hid);
		ModelAndView mv = new ModelAndView();
		List<HotelPrice> hotelPrices = hotelService.getAllHouse(map);
		mv.setViewName("houseList");
		mv.addObject("hotelPrices", hotelPrices);
		return mv;
	}
	@RequestMapping("/deleteHouse")
	public ModelAndView deleteHouse(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		int hpid = Integer.parseInt(request.getParameter("hpid"));
		map.put("hpid",hpid);
		ModelAndView mv = new ModelAndView();
		hotelService.deleteHouse(map);
		mv.setViewName("houseList");
		mv.addObject("hpid",hpid );
		return mv;
	}
}
