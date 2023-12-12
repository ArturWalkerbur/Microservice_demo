package com.microservices.rentersserver.services.impl;



import com.microservices.rentersserver.entity.CarRental;
import com.microservices.rentersserver.repository.CarRentalRepository;
import com.microservices.rentersserver.services.CarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarRentalServiceImpl implements CarRentalService {

    @Autowired
    private CarRentalRepository carRentalRepository;

    @Override
    public CarRental addCarRental(CarRental carRental) {
        return carRentalRepository.save(carRental);
    }

    @Override
    public List<CarRental> getCarRentals() {
        return carRentalRepository.findAll();
    }

    @Override
    public CarRental getCarRental(Long id) {
        return carRentalRepository.getReferenceById(id);
    }

    @Override
    public void deleteCarRental(CarRental carRental) {
        carRentalRepository.delete(carRental);
    }

    @Override
    public CarRental saveCarRental(CarRental carRental) {
        return carRentalRepository.save(carRental);
    }
}
