package com.jnmd.liuwan.controller.hotelController;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
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
	public ModelAndView updateHouse(int hpid,HttpServletRequest request,HotelPrice hotelPrice){
		
		ModelAndView mv = new ModelAndView();
		hotelService.updateHouse(hotelPrice);
		mv.addObject("hpid",hpid);
		mv.setViewName("updateHousePic");
		return mv;
	}
	@RequestMapping("/updateHousePic")
	public ModelAndView updateHousePic(int hpid,HttpServletRequest request,MultipartFile file){
		ModelAndView mv = new ModelAndView();
		Map<String,Object> map=new HashMap<String, Object>();
		String path = request.getSession().getServletContext().getRealPath("/img/msgimg");  
	    String fileName = file.getOriginalFilename();  
	    String picPath = "./img/msgimg/"+fileName;
	    System.out.println(picPath);
	    System.out.println(hpid);
	    File dir = new File(path, fileName);  
        if(!dir.exists()){  
            dir.mkdirs();  
        }  
        try {
			file.transferTo(dir);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        map.put("picPath", picPath);
        map.put("hpid", hpid);
        hotelService.updateHousePic(map);
        mv.setViewName("updateHouseSucc");
		
		
		return mv;
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
	
	
	
	//.........
	@RequestMapping("/addHotel")
	public ModelAndView addHotel(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addHotel");
		return mv;
	}
	@RequestMapping("/addAHotel")
	public ModelAndView addAhotel(Hotel hotel){
		ModelAndView mv = new ModelAndView();
		hotelService.addHotel(hotel);
		mv.addObject("hid", hotel.getHid());
		mv.setViewName("addHotelPic");
		return mv;
	}
	@RequestMapping("/addHotelPic")
	public ModelAndView addHotelPic(int hid,MultipartFile file,HttpServletRequest request)throws IOException{
		Map<String,Object> map = new HashMap<String,Object>();
		ModelAndView mv = new ModelAndView();
		map.put("hid", hid);
       String path = request.getSession().getServletContext().getRealPath("/img/msgimg");  
       String fileName = file.getOriginalFilename();  
        String picPath = "./img/msgimg/"+fileName;
        map.put("picPath", picPath);
        File dir = new File(path, fileName);  
        if(!dir.exists()){  
            dir.mkdirs();  
        }  
        hotelService.addHotelPic(map);
        file.transferTo(dir);
        mv.setViewName("addHotelSucc");
       return mv;
	}
	
	
	
	@RequestMapping("/addHouse")
	public ModelAndView addHouse(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		int hid = Integer.parseInt(request.getParameter("hid"));
		Map<String,Integer> map=new HashMap<String, Integer>();
		map.put("hid", hid);
		map.put("pid", hid);
		hotelService.saveMid(map);
		mv.setViewName("addHousePage");
		
		return mv;
	}
	@RequestMapping("/addHouseCon")
	public ModelAndView addHouseCon(HttpServletRequest request){
		
		ModelAndView mv = new ModelAndView();
		int city_id=Integer.parseInt(request.getParameter("city_id"));
		int house_id=Integer.parseInt(request.getParameter("house_id"));
		double price=Double.parseDouble(request.getParameter("price"));
		int area=Integer.parseInt(request.getParameter("area"));
		int floor=Integer.parseInt(request.getParameter("floor"));
		String smoke=request.getParameter("smoke");
		int peomax=Integer.parseInt(request.getParameter("peomax"));
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("city_id", city_id);
		map.put("house_id", house_id);
		map.put("price", price);
		map.put("area", area);
		map.put("floor", floor);
		map.put("smoke", smoke);
		map.put("peomax", peomax);
		hotelService.saveHouse(map);
		mv.setViewName("addHousePic");
		
		return mv;
	}
	
	@RequestMapping("/addHousePic")
	public ModelAndView addHousePic(HttpServletRequest request,MultipartFile file){
		ModelAndView mv = new ModelAndView();
		Map<String,Object> map=new HashMap<String, Object>();
		String path = request.getSession().getServletContext().getRealPath("/img/msgimg");  
	    String fileName = file.getOriginalFilename();  
	    String picPath = "./img/msgimg/"+fileName;
	    int housepid=hotelService.maxId();
	    File dir = new File(path, fileName);  
        if(!dir.exists()){  
            dir.mkdirs();  
        }  
        try {
			file.transferTo(dir);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        map.put("picPath", picPath);
        map.put("housepid", housepid);
        hotelService.saveHousePic(map);
        mv.setViewName("addHouseSucc");
		
		
		return mv;
	}
	
}
