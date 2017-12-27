package com.jnmd.liuwan.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.omg.CORBA.UserException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jnmd.liuwan.domain.Hotel;
import com.jnmd.liuwan.domain.HotelMid;
import com.jnmd.liuwan.domain.HotelPic;
import com.jnmd.liuwan.domain.HotelPrice;
import com.jnmd.liuwan.domain.Recommend;
import com.jnmd.liuwan.exception.HotelException;
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
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<HotelPrice> getAllHouse(Map<String,Object> map){
		return hotelMapper.getAllHouse(map);
	}
	
	@Transactional(rollbackFor=HotelException.class)
	public void deleteHouse(Map<String,Object> map){
		hotelMapper.deleteHouse(map);
	}
	@Transactional(rollbackFor=HotelException.class)
	 public void deleteMidByPid(Map<String,Object> map){
	 	hotelMapper.deleteMidByPid(map);
	 }
	 @Transactional(rollbackFor=HotelException.class)
	 public void deleteHotel(Map<String,Object> map){
	 	hotelMapper.deleteHotel(map);
	 }
	
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public Hotel getHotel(int hid){
		return hotelMapper.getHotel(hid);
	}
	
	@Transactional(rollbackFor=HotelException.class)
	public void updateHotelId(Hotel hotel){
		hotelMapper.updateHotelId(hotel);
	}
	
	@Transactional(rollbackFor=HotelException.class)
	public HotelPrice getHouse(int hpid){
		return hotelMapper.getHouse(hpid);
	}
	
	@Transactional(rollbackFor=HotelException.class)
	public void updateHouse(HotelPrice hotelPrice){
		hotelMapper.updateHouse(hotelPrice);
	}
	
	
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Recommend> getRec(){
		
		return hotelMapper.getRec();
	}
	//详情
		@Transactional(propagation=Propagation.SUPPORTS)
		public List<Recommend> getDec(){
			return hotelMapper.getDec();
		}
		
		@Transactional(propagation=Propagation.SUPPORTS)
		public void delete(int rid){
			hotelMapper.delete(rid);
		}
		
		@Transactional(propagation=Propagation.SUPPORTS)
		public Recommend findRecommedById(Map<String,Object> map) {
			return hotelMapper.findID(map);
		}
		
		@Transactional(propagation=Propagation.SUPPORTS)
		public void update(Map<String,Object> map){
			hotelMapper.updateRec(map);
		}
		
		
		@Transactional(propagation=Propagation.SUPPORTS)
		public Recommend getRecommend(int rid){
			return hotelMapper.getRecommend(rid);
		}
		
		@Transactional(propagation=Propagation.SUPPORTS)
		public void saveRecommend(Recommend recommend){
			hotelMapper.saveRecommend(recommend);
		}
		
		
		
		
		
		@Transactional(rollbackFor=HotelException.class)
		public void addHotel(Hotel hotel){
			hotelMapper.addHotel(hotel);
		}
		@Transactional(rollbackFor=HotelException.class)
		public void addHotelPic(Map<String , Object> map){
			hotelMapper.addHotelPic(map);
		}
		
		
		@Transactional(rollbackFor=HotelException.class)
		public void saveMid(Map<String,Integer> map){
			hotelMapper.saveMid(map);
		}
		
		
		@Transactional(rollbackFor=HotelException.class)
		public void saveHouse(Map<String,Object> map){
			hotelMapper.saveHouse(map);
		}
		
		
		@Transactional(rollbackFor=HotelException.class)
		public int maxId(){
			return hotelMapper.maxId();
		}
		
		@Transactional(rollbackFor=HotelException.class)
		public void saveHousePic(Map<String, Object> map){
			hotelMapper.saveHousePic(map);
		}
		
		
		@Transactional(rollbackFor=HotelException.class)
		public void updateHousePic(Map<String, Object> map){
			hotelMapper.updateHousePic(map);
		}
}
