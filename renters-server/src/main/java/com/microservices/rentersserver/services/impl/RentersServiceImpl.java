package com.microservices.rentersserver.services.impl;



import com.microservices.rentersserver.entity.Renters;
import com.microservices.rentersserver.repository.RentersRepository;
import com.microservices.rentersserver.services.RentersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentersServiceImpl implements RentersService {


    @Autowired
    private RentersRepository rentersRepository;

    @Override
    public Renters addRenter(Renters renters) {
        return rentersRepository.save(renters);
    }

    @Override
    public List<Renters> getRenters() {
        return rentersRepository.findAll();
    }

    @Override
    public Renters getRenter(Long id) {
        return rentersRepository.getById(id);
    }

    @Override
    public void deleteRenter(Renters renter) {
        rentersRepository.delete(renter);
    }

    @Override
    public Renters saveRenter(Renters renter) {
        return rentersRepository.save(renter);
    }
}
