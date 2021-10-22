package com.example.demo.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.RailwayRes;

@Repository
public interface RailwayResRepository extends JpaRepository<RailwayRes, Integer> {

	@Query( value = "SELECT * FROM public.railway_res where railway_res.startfrom=?1", nativeQuery = true)
	public List<RailwayRes> displayByStartFrom(String startfrom);
	
	@Transactional
	@Modifying
	@Query(value = "delete from public.railway_res where railway_res.to_destination=?1", nativeQuery = true)
	public void deleteByToDestination(String to_destination);
	
	@Query(value = "select *from public.railway_res order by railway_res.price asc", nativeQuery = true)
	public List<RailwayRes> displayAllResrvationSortByPrice();
	
	@Transactional
	@Modifying
	@Query(value = "update railway_res set price= ?1, startfrom= ?2 where id= ?3", nativeQuery = true)
    public int partialRecordUpdate(int price,String startfrom,int id);
}
