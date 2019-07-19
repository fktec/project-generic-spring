package com.back.genericbasicspringboot.common.api.car.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.genericbasicspringboot.common.api.car.model.Car;
import com.back.genericbasicspringboot.common.api.car.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;

	@Transactional
	public Car save(Car car) {
		return carRepository.save(car);
	}
	
	public List<Car> getCars() {
		return carRepository.findAll();
	}

}
