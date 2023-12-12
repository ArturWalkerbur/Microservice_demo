package com.microservices.ownersserver.services.impl;



import com.microservices.ownersserver.entity.Owners;
import com.microservices.ownersserver.repository.OwnersRepository;
import com.microservices.ownersserver.services.OwnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnersServiceImpl implements OwnersService {

    @Autowired
    private OwnersRepository ownersRepository;

    @Override
    public Owners addOwner(Owners owners) {
        return ownersRepository.save(owners);
    }

    @Override
    public List<Owners> getOwners() {
        return ownersRepository.findAll();
    }

    @Override
    public Owners getOwner(Long id) {
        return ownersRepository.getById(id);
    }

    @Override
    public void deleteOwner(Owners owner) {
        ownersRepository.delete(owner);
    }

    @Override
    public Owners saveOwner(Owners owner) {
        return ownersRepository.save(owner);
    }
}
