package com.jnmd.liuwan.controller.hotelController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jnmd.liuwan.domain.Hotel;
import com.jnmd.liuwan.domain.HotelMid;
import com.jnmd.liuwan.domain.HotelPic;
import com.jnmd.liuwan.domain.HotelPrice;
import com.jnmd.liuwan.domain.Province;
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
	public ModelAndView getAllHouse(int hid){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("hid", hid);
		ModelAndView mv = new ModelAndView();
		List<HotelPrice> hotelPrices = hotelService.getAllHouse(map);
		mv.setViewName("houseList");
		mv.addObject("hotelPrices", hotelPrices);
		mv.addObject("hid", hid);
		return mv;
	}
	@RequestMapping("/deleteHouse")
	public String deleteHouse(int hid,int hpid){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("hpid",hpid);
		ModelAndView mv = new ModelAndView();
		hotelService.deleteHouse(map);
		hotelService.deleteMidByPid(map);
		mv.setViewName("houseList");
		mv.addObject("hpid",hpid );
		mv.addObject("hid", hid);
		return "redirect:getAllHouse?hid="+hid;
	}
	@RequestMapping("/deleteHotel")
	public String deleteHotel(int hid,int pageNum){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("hid", hid);
		ModelAndView mv = new ModelAndView();
		hotelService.deleteHotel(map);
		int maxNum = hotelService.maxNum();
		if(pageNum*5>maxNum){
			pageNum=pageNum-1;
		}
		if(pageNum<=1){
			pageNum=1;
		}
		return "redirect:getHotels?pageNum="+pageNum;
	}
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
        mv.addObject("hid", hid);
        mv.setViewName("addHotelSuc");
        return mv;
	}
	@RequestMapping("/toAddHotelPic")
	public ModelAndView toAddHotelPic(int hid){
		ModelAndView mv = new ModelAndView();
		mv.addObject("hid", hid);
		mv.setViewName("addHotelPic");
		return mv;
	}
	@RequestMapping("/doNotAddPic")
	public String toHotelList(int pageNum){
		return "redirect:getHotels?pageNum="+pageNum;
	}
	@RequestMapping("/getHotel")
	public ModelAndView getHotel(int hid,int pageNum){
		Hotel hotel = hotelService.getHotel(hid);
		ModelAndView mv = new ModelAndView();
		mv.addObject("hotel", hotel);
		mv.addObject("pageNum",pageNum);
		mv.setViewName("updateHotel");
		return mv;
	}
	@RequestMapping("/updateHotel")
	public String updateHotel(Hotel hotel,int pageNum){
		hotelService.updateHotel(hotel);
		ModelAndView mv = new ModelAndView();
		return "redirect:getHotels?pageNum="+pageNum;
	}
	@RequestMapping("/deleteAHotelPicByPath")
	public String deleteAHotelPic(int pageNum,String picPath,int hid,HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("picPath", picPath);
		map.put("hid", hid);
		hotelService.deleteAHotelPic(map);
		String relativePath = "/img/msgimg";
		String absolutePath = request.getSession().getServletContext().getRealPath(relativePath);
		String[] fileNames = picPath.split("/");
		String fileName = fileNames[fileNames.length-1];
		File file = new File(absolutePath+"\\"+fileName);
		if(file.exists()){
			file.delete();
		}
		return "redirect:getHotels?pageNum="+pageNum;
	}
	@RequestMapping("/addHouse")
	public ModelAndView getCityListToAddHouse(int hid){
		ModelAndView mv = new ModelAndView();
		List<Province> provinces = hotelService.getCityList();
		mv.addObject("provinces", provinces);
		mv.addObject("hid", hid);
		mv.setViewName("addHousePage");
		return mv;
	}
	@RequestMapping("/addAHouse")
	public ModelAndView addHouseCon(int hid,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		int city_id=Integer.parseInt(request.getParameter("city_id"));
		int house_id=Integer.parseInt(request.getParameter("house_id"));
		double price=Double.parseDouble(request.getParameter("price"));
		int area=Integer.parseInt(request.getParameter("area"));
		int floor=Integer.parseInt(request.getParameter("floor"));
		char smoke=request.getParameter("smoke").charAt(0);
		int peomax=Integer.parseInt(request.getParameter("peomax"));
		HotelPrice house = new HotelPrice(city_id,house_id,price,area,floor,smoke,peomax);
		hotelService.addAHouse(house);
		mv.addObject("housepid", house.getHpid());
		mv.addObject("hid", hid);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("hid", hid);
		map.put("pid", house.getHpid());
		hotelService.addHotelMid(map);
		mv.setViewName("addHousePic");
		return mv;
	}
	@RequestMapping("/addHousePic")
	public String addHousePic(int hid,int housepid,MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException{
		ModelAndView mv = new ModelAndView();
		Map<String,Object> map = new HashMap<String,Object>();
		String path = request.getSession().getServletContext().getRealPath("/img/msgimg");  
        String fileName = file.getOriginalFilename();  
        String picPath = "./img/msgimg/"+fileName;
        File dir = new File(path, fileName);  
        if(!dir.exists()){  
            dir.mkdirs();  
        }  
        file.transferTo(dir);
        map.put("housepid", housepid);
        map.put("picPath", picPath);
        hotelService.addHousePic(map);
		return "redirect:getAllHouse?hid="+hid;
	}
	@RequestMapping("/changeHousePic")
	public ModelAndView changeHousePic(int hid,int housepid,String picPath,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		String relativePath = "/img/msgimg";
		String absolutePath = request.getSession().getServletContext().getRealPath(relativePath);
		String[] fileNames = picPath.split("/");
		String fileName = fileNames[fileNames.length-1];
		File file = new File(absolutePath+"\\"+fileName);
		if(file.exists()){
			file.delete();
		}
		mv.addObject("housepid", housepid);
		mv.addObject("hid", hid);
		mv.setViewName("changeHousePic");
		return mv;
	}
	@RequestMapping("/updateHousePic")
	public String updateHousePic(int hid,int housepid,MultipartFile file,HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		Map<String,Object> map = new HashMap<String,Object>();
		String path = request.getSession().getServletContext().getRealPath("/img/msgimg");  
        String fileName = file.getOriginalFilename();  
        String picPath = "./img/msgimg/"+fileName;
        File dir = new File(path, fileName);  
        if(!dir.exists()){  
            dir.mkdirs();  
        }  
        file.transferTo(dir);
        map.put("housepid", housepid);
        map.put("picPath", picPath);
        hotelService.updateHousePic(map);
		return "redirect:getAllHouse?hid="+hid;
	}
	@RequestMapping("/updateHouseMsg")
	public ModelAndView updateHouseMsg(int hpid,int hid){
		ModelAndView mv = new ModelAndView();
		List<Province> provinces = hotelService.getCityList();
		HotelPrice house = hotelService.getAHouse(hpid);
		mv.addObject("provinces", provinces);
		mv.addObject("area", house.getArea());
		mv.addObject("city_id", house.getCity_id());
		mv.addObject("floor", house.getFloor());
		mv.addObject("house_id", house.getHouse_id());
		mv.addObject("hpid", house.getHpid());
		mv.addObject("peomax", house.getPeomax());
		mv.addObject("price", house.getPrice());
		mv.addObject("smoke", house.getSmoke());
		mv.addObject("hid", hid);
		mv.setViewName("updateHouseMsg");
		return mv;
	}
	@RequestMapping("/updateHouseMessage")
	public String updateHouseMessage(int hid,HttpServletRequest request){
		int hpid = Integer.parseInt(request.getParameter("hpid"));
		int city_id=Integer.parseInt(request.getParameter("city_id"));
		int house_id=Integer.parseInt(request.getParameter("house_id"));
		double price=Double.parseDouble(request.getParameter("price"));
		int area=Integer.parseInt(request.getParameter("area"));
		int floor=Integer.parseInt(request.getParameter("floor"));
		char smoke=request.getParameter("smoke").charAt(0);
		int peomax=Integer.parseInt(request.getParameter("peomax"));
		HotelPrice house = new HotelPrice(hpid,city_id,house_id,price,area,floor,smoke,peomax);
		hotelService.updateHouseMessage(house);
		return "redirect:getAllHouse?hid="+hid;
	}
}
