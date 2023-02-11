package com.microservice.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.entity.HotelDetails;
import com.microservice.exception.HotelDetailsNotFoundException;
import com.microservice.repository.HotelDetailsRepository;


@Service
public class HotelDetailsServiceImpl implements HotelDetailsService{
	
	@Autowired
	private HotelDetailsRepository repository;
	
	private final Logger logger = LoggerFactory.getLogger(HotelDetailsServiceImpl.class); 

//	GET ALL
	
	@Override
	public List<HotelDetails> getAll() {
		logger.info("getALl() -> | ");
		List<HotelDetails> list = repository.findAll();
		logger.info("getALl() -> | HotelDetails List : {}",list);
		return list;
	}
	
//	GET BY ID

	@Override
	public HotelDetails getById(int id) {
		logger.info("getById() -> | id : {}",id);
		HotelDetails hotelDetails = repository.findById(id)
				.orElseThrow(() -> new HotelDetailsNotFoundException("Hotel Details Not Found Exception"));
		logger.info("getById() -> | Hotel Details : {}",hotelDetails);
		return hotelDetails;
	}

//	CREATE 
	
	@Override
	public HotelDetails createHotel(HotelDetails hotelDetails) {
		logger.info("createHotel() -> | HotelDetails : {}",hotelDetails);
		HotelDetails hotel = repository.save(hotelDetails);
		logger.info("createHotel() -> | HotelDetails : {}",hotel);
		return hotel;
	}
	
//	DELETE BY ID

	@Override
	public String deleteById(int id) {
		logger.info("deleteById() -> | id : {}",id);
		if(isPresentInDb(id)) {
			repository.deleteById(id);
			logger.info("Deleted...");
		}
		logger.info("deleteById() -> | id : {}",id);
		return "Deleted... id : "+id;
	}
	
//	isPresent
	
	private boolean isPresentInDb(int id) {
		logger.info("isPresentInDb() -> | id : {}",id);
		Optional<HotelDetails> get = repository.findById(id);
		logger.info("isPresentInDb() -> | HotelDetails : {}", get
				.orElseThrow(() -> new HotelDetailsNotFoundException("Hotel Not Present Id : " + id)));
		
		return get.isPresent();
	}
	
//	UPDATE

	@Override
	public HotelDetails updateHotel(int id, HotelDetails hotel) {
		logger.info("updateHotel() -> | id : {} | HotelDetails : {}",id,hotel);
		HotelDetails hotelDetails = getById(id);
		logger.info("After Getting Object HotelDetails : {}",hotelDetails);
		
		logger.info("Setting values -> ");
		hotelDetails.setHotelName(hotel.getHotelName());
		hotelDetails.setOwnnerName(hotel.getOwnnerName());
		hotelDetails.setHotelAddress(hotel.getHotelAddress());
		
		logger.info("updateHotel() -> | HotelDetails : {}",hotelDetails);
		return hotelDetails;
	}

	@Override
	public List<HotelDetails> findByUserId(int id) {
//		List<HotelDetails> hotel=null;
		logger.info("findByUserId() -> | UserId : " + id);
		List<HotelDetails> hotel = repository.findByUserId(id);
		if(hotel != null) {
			logger.info("get Hotels with UserId : {}",id);
		}
		else 
			throw new HotelDetailsNotFoundException("User Not Found id : "+id);
		logger.info("findByUserID() -> | Hotels : {}",hotel);
		return hotel;
	}
	

}









