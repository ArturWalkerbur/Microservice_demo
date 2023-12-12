package com.microservices.rentersserver.services;



import com.microservices.rentersserver.entity.CarRental;

import java.util.List;

public interface CarRentalService {

    CarRental addCarRental(CarRental carRental);
    List<CarRental> getCarRentals();
    CarRental getCarRental(Long id);
    void deleteCarRental(CarRental carRental);
    CarRental saveCarRental(CarRental carRental);

}
