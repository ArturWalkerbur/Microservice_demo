package com.microservices.ownersserver.services;







import com.microservices.ownersserver.entity.CarOwnership;

import java.util.List;

public interface CarOwnershipService {

    CarOwnership addCarOwnership(CarOwnership carOwnership);
    List<CarOwnership> getCarOwnerships();
    CarOwnership getCarOwnership(Long id);
    void deleteCarOwnership(CarOwnership carOwnership);
    CarOwnership saveCarOwnership(CarOwnership carOwnership);

}
