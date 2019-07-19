package com.back.genericbasicspringboot.common.api.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back.genericbasicspringboot.common.api.car.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
