package com.microservices.ownersserver.services;






import com.microservices.ownersserver.entity.Owners;

import java.util.List;

public interface OwnersService {

    Owners addOwner(Owners owners);
    List<Owners> getOwners();
    Owners getOwner(Long id);
    void deleteOwner(Owners owner);
    Owners saveOwner(Owners owner);

}
