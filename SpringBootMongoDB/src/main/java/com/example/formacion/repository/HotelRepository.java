package com.example.formacion.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.formacion.dto.Hotel;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String>{
	
	Optional<Hotel> findById (String id);
	List<Hotel> findByPricePerNightLessThan(int maxPrice);
	
	@Query(value = "{addres.city:?0}")
	List<Hotel> findByCity(String city);
	
	
	

}
