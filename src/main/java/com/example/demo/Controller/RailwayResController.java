package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.RailwayRes;
import com.example.demo.Service.RailwayResService;

@RestController
public class RailwayResController {

	public final RailwayResService resService;

	@Autowired
	public RailwayResController(RailwayResService resService) {
		this.resService = resService;
	}
	
	@PostMapping("RailwayRes")
	RailwayRes reserveRailwaySeat(@RequestBody RailwayRes res) {
		return resService.reserveSeat(res);
		
	}
	
	@GetMapping("RailwayRes/{id}")
	RailwayRes showReservationById(@PathVariable Integer id) {
		return resService.showReservationById(id);
		
	}
	
	@GetMapping("RailwayRes")
	List<RailwayRes> displayallReservation() {
		return resService.displayAllReservation();
		
	}
	
	@PutMapping("RailwayRes")
	RailwayRes updateReservation(@RequestBody RailwayRes res) {
		return resService.updateReservationById(res);
		
	}
	
	@DeleteMapping("RailwayRes/{id}")
	void deletReservationById(@PathVariable Integer id) {
		 resService.deleteReservationById(id);
	}
	
	@GetMapping("/startfrom/{startfrom}")
   List<RailwayRes> displayReservationBySartFrom(@PathVariable String startfrom){
	return resService.displayByStartFrom(startfrom);
	   
   }
	@DeleteMapping("to_destination/{to_destination}")
	void deleteReservationByToDestination(@PathVariable String to_destination ) {
		 resService.deleteReservationByToDestination(to_destination);
		
	}
	@GetMapping("RailwayRes/SortByPrice")
	List<RailwayRes> displayAllResSortedByPriceAssendingOrder(){
		return resService.displayAllReservationSortedByPriceAscendingOrder();
		
	}
	
	@PatchMapping("RailwayRes/update/{price}/{startfrom}/{id}")
	int updatePartialRecord(@PathVariable int price,@PathVariable String startfrom,@PathVariable int id) {
		return resService.updatePartialRecord(price, startfrom, id);
	}
	
	
	
}
