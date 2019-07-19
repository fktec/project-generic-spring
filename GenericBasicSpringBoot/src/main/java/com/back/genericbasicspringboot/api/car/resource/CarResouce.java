package com.back.genericbasicspringboot.api.car.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.genericbasicspringboot.common.api.car.model.Car;
import com.back.genericbasicspringboot.common.api.car.service.CarService;

@RestController
@RequestMapping("/car")
public class CarResouce {
	
	@Autowired
	private CarService carService;

	@GetMapping
	public ResponseEntity<List<Car>> getCars() {
		List<Car> cars = carService.getCars();
		return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> saveCar(@RequestBody Car car) {
		Car carSave = carService.save(car);
		return new ResponseEntity<>(carSave, HttpStatus.OK);
	}
}
