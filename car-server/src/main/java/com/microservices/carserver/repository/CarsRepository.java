package com.microservices.carserver.repository;



import com.microservices.carserver.entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CarsRepository extends JpaRepository<Cars, Long> {
    List<Cars> findAllByCarnameOrModel(String carName, String model);
    List<Cars> findAllByYear(Long year);
    List<Cars> findAllByVolume(double volume);
    Cars getById(Long id);

}
