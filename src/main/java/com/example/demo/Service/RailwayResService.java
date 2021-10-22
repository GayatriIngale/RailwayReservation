package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.RailwayRes;

public interface RailwayResService {
	
	RailwayRes  reserveSeat(RailwayRes res);
	RailwayRes  showReservationById(Integer id);
	List<RailwayRes> displayAllReservation();
	RailwayRes  updateReservationById(RailwayRes res);
	void deleteReservationById(Integer id);
	List<RailwayRes> displayByStartFrom(String startfrom);
	void deleteReservationByToDestination(String to_destination);
	List<RailwayRes> displayAllReservationSortedByPriceAscendingOrder();
	int updatePartialRecord(int price,String startfrom,int id);
}
