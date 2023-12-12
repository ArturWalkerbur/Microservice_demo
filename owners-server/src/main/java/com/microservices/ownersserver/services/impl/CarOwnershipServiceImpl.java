package com.microservices.ownersserver.services.impl;



import com.microservices.ownersserver.entity.CarOwnership;
import com.microservices.ownersserver.repository.CarOwnershipRepository;
import com.microservices.ownersserver.services.CarOwnershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarOwnershipServiceImpl implements CarOwnershipService {

    @Autowired
    private CarOwnershipRepository carOwnershipRepository;

    @Override
    public CarOwnership addCarOwnership(CarOwnership carOwnership) {
        return carOwnershipRepository.save(carOwnership);
    }

    @Override
    public List<CarOwnership> getCarOwnerships() {
        return carOwnershipRepository.findAll();
    }

    @Override
    public CarOwnership getCarOwnership(Long id) {
        return carOwnershipRepository.getById(id);
    }

    @Override
    public void deleteCarOwnership(CarOwnership carOwnership) {
        carOwnershipRepository.delete(carOwnership);
    }

    @Override
    public CarOwnership saveCarOwnership(CarOwnership carOwnership) {
        return carOwnershipRepository.save(carOwnership);
    }
}
