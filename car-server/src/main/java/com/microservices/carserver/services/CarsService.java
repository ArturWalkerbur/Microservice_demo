package com.microservices.carserver.services;





import com.microservices.carserver.entity.Cars;

import java.util.List;

public interface CarsService {

    Cars addCar(Cars cars);
    List<Cars> getALlCars();
    List<Cars> searchCars(String text);
    List<Cars> filterCars(Long year);
    List<Cars> filterCars2(double volume);
    Cars getCar(Long id);
    void deleteCars(Cars cars);
    Cars saveCars(Cars cars);

}
