package com.microservices.carserver.services.impl;



import com.microservices.carserver.entity.Cars;
import com.microservices.carserver.repository.CarsRepository;
import com.microservices.carserver.services.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsServiceImpl implements CarsService {

    @Autowired
    private CarsRepository carsRepository;


    @Override
    public Cars addCar(Cars cars) {
        return carsRepository.save(cars);
    }

    @Override
    public List<Cars> getALlCars() {
        return carsRepository.findAll();
    }

    @Override
    public List<Cars> searchCars(String text) {
        return carsRepository.findAllByCarnameOrModel(text, text);
    }

    @Override
    public List<Cars> filterCars(Long year) {
        return carsRepository.findAllByYear(year);
    }

    @Override
    public List<Cars> filterCars2(double volume) {
        return carsRepository.findAllByVolume(volume);
    }

    @Override
    public Cars getCar(Long id) {
        return carsRepository.getById(id);
    }

    @Override
    public void deleteCars(Cars cars) {
        carsRepository.delete(cars);
    }

    @Override
    public Cars saveCars(Cars cars) {
        return carsRepository.save(cars);
    }
}
