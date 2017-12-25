package com.jnmd.liuwan.controller.hotelController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jnmd.liuwan.domain.Hotel;
import com.jnmd.liuwan.domain.HotelMid;
import com.jnmd.liuwan.domain.HotelPic;
import com.jnmd.liuwan.domain.HotelPrice;
import com.jnmd.liuwan.domain.Recommend;
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
	
	
	@RequestMapping("/deleteHotel")
	 	public ModelAndView deleteHotel(HttpServletRequest request){
	 		Map<String,Object> map = new HashMap<String,Object>();
	 		int hid = Integer.parseInt(request.getParameter("hid"));
	 		map.put("hid", hid);
	 		ModelAndView mv = new ModelAndView();
	 		hotelService.deleteHotel(map);
	 		mv.setViewName("deleteHotelTest");
	 		return mv;
	 	}
	
	@RequestMapping("/getHotel")
	public ModelAndView updatePage(HttpServletRequest request){
		int hid = Integer.parseInt(request.getParameter("hid"));
		Hotel hotel=hotelService.getHotel(hid);
		ModelAndView mv = new ModelAndView();
		System.out.println(hotel);
		mv.setViewName("forward:/WEB-INF/jsp/admin/updatePage.jsp");
		mv.addObject("hotel", hotel);
		return mv;
	}
	
	@RequestMapping("/updatePageId")
	public String updatePageId(HttpServletRequest request,Hotel hotel){
		
		
		hotelService.updateHotelId(hotel);
		
		return "forward:/WEB-INF/jsp/admin/updateSuccess.jsp";
	}
	
	
	@RequestMapping("/getHouse")
	public ModelAndView getHouse(HttpServletRequest request){
		int hpid = Integer.parseInt(request.getParameter("hpid"));
		ModelAndView mv = new ModelAndView();
		HotelPrice hotelPrice=hotelService.getHouse(hpid);
		mv.addObject("hotelPrice", hotelPrice);
		mv.setViewName("forward:/WEB-INF/jsp/admin/updateHouse.jsp");
		return mv;
	}
	
	
	@RequestMapping("/updatePageHouse")
	public String updateHouse(HttpServletRequest request,HotelPrice hotelPrice){
		
		
		hotelService.updateHouse(hotelPrice);
		
		return "forward:/WEB-INF/jsp/admin/updateHouseSuccess.jsp";
	}
	
	//举
	
	@RequestMapping("/Travel")
	public ModelAndView getRec(){
		List<Recommend> rec = hotelService.getRec();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("forward:/WEB-INF/jsp/admin/next.jsp");
		
		mv.addObject("rec", rec);
		return mv;
	}
	
	@RequestMapping("/datail")
	public ModelAndView getDec(HttpServletRequest request){
		int rid = Integer.parseInt(request.getParameter("rid"));
		Recommend recommend=hotelService.getRecommend(rid);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("forward:/WEB-INF/jsp/admin/datails.jsp");
		
		mv.addObject("recommend", recommend);
		return mv;
		
	}
	
	//删除
	@RequestMapping("/delete/{rid}")
	public ModelAndView delete(@PathVariable("rid") Integer rid){
		hotelService.delete(rid);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("forward:/WEB-INF/jsp/admin/succes.jsp");
		return mv;
	}
	//更新
	@RequestMapping("/findRecommedById")
	public ModelAndView findID(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		int rid = Integer.parseInt(request.getParameter("rid"));
		map.put("rid",rid);
		Recommend rec = hotelService.findRecommedById(map);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("update");
		mv.addObject("rec", rec);
		return mv;
	}
	
	@RequestMapping("/updateRec")
	public ModelAndView updateRec(HttpServletRequest req){
		Map<String,Object> map = new HashMap<String,Object>();
		int rid = Integer.parseInt(req.getParameter("rid"));
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String introduce = req.getParameter("introduce");
		double price = Double.parseDouble(req.getParameter("price"));
		int likes = Integer.parseInt(req.getParameter("likes"));
		int comment = Integer.parseInt(req.getParameter("comment"));
		map.put("rid",rid);
		map.put("title",title);
		map.put("description",description);
		map.put("introduce",introduce);
		map.put("price",price);
		map.put("likes",likes);
		map.put("comment",comment);
		
		ModelAndView mv = new ModelAndView();
		hotelService.update(map);
		mv.setViewName("updatesucces");
		return mv;
	}
	
	@RequestMapping("/test")
	public ModelAndView test(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("test");
		return mv;
	}
	
	@RequestMapping("/Change")
	public String change(){
		return "forward:/WEB-INF/jsp/admin/saveRecom.jsp";
	}
	
	@RequestMapping("/saveRecommend")
	public String saveRecommend(HttpServletRequest request,Recommend recommend){
		hotelService.saveRecommend(recommend);
		return "forward:/WEB-INF/jsp/admin/saveRecommendSucc.jsp";
	}
}
