package com.microservices.rentersserver.services;





import com.microservices.rentersserver.entity.Renters;

import java.util.List;

public interface RentersService {


    Renters addRenter(Renters renters);
    List<Renters> getRenters();
    Renters getRenter(Long id);
    void deleteRenter(Renters renter);
    Renters saveRenter(Renters renter);

}
