package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.RailwayRes;
import com.example.demo.Repository.RailwayResRepository;

@Service
public class RailwayResServiceImpl  implements RailwayResService{

	public final RailwayResRepository resRepository;
	
	@Autowired
	public RailwayResServiceImpl(RailwayResRepository resRepository) {
		this.resRepository = resRepository;
	}


	@Override
	public RailwayRes reserveSeat(RailwayRes res) {
		return resRepository.save(res);
	}


	@Override
	public RailwayRes showReservationById(Integer id) {
		return resRepository.findById(id).get();
	}


	@Override
	public List<RailwayRes> displayAllReservation() {
		return resRepository.findAll();
	}


	@Override
	public RailwayRes updateReservationById(RailwayRes res) {
		return resRepository.save(res);
	}


	@Override
	public void deleteReservationById(Integer id) {
		resRepository.deleteById(id);
	}


	@Override
	public List<RailwayRes> displayByStartFrom(String startfrom) {
		return resRepository.displayByStartFrom(startfrom);
	}


	@Override
	public void deleteReservationByToDestination(String to_destination) {
		 resRepository.deleteByToDestination(to_destination);
		
	}


	@Override
	public List<RailwayRes> displayAllReservationSortedByPriceAscendingOrder() {
		return resRepository.displayAllResrvationSortByPrice();
	}


	@Override
	public int updatePartialRecord(int price, String startfrom, int id) {
		 return resRepository.partialRecordUpdate(price, startfrom, id);
	}

}
