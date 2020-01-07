package com.example.formacion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.formacion.dto.Hotel;
import com.example.formacion.repository.HotelRepository;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	private HotelRepository hotelRepository;

	public HotelController(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	@GetMapping("/all")
	public List<Hotel> getAll() {
		List<Hotel> hotels = this.hotelRepository.findAll();

		return hotels;
	}

	// investigar putmaping
	@PutMapping
	public void insert(@RequestBody Hotel hotel) {
		this.hotelRepository.insert(hotel);
	}

	@PostMapping
	public void update(@RequestBody Hotel hotel) {
		this.hotelRepository.save(hotel);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		this.hotelRepository.deleteById(id);
	}

	@GetMapping("/{id}")
	public Optional<Hotel> getById(@PathVariable("id") String id) {
		Optional<Hotel> hotel = this.hotelRepository.findById(id);
		return hotel;
	}

	@GetMapping("/price/{maxPrice}")
	public List<Hotel> getByPricePerNight(@PathVariable("maxPrice") int maxPrice) {
		List<Hotel> hotels = this.hotelRepository.findByPricePerNightLessThan(maxPrice);
		return hotels;
	}

	@GetMapping("/address/{city}")
	public List<Hotel> getByCity(@PathVariable("city") String city) {
		List<Hotel> hotels = this.hotelRepository.findByCity(city);
		return hotels;
	}

}
