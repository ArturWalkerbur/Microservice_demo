package com.microservices.rentersserver.repository;



import com.microservices.rentersserver.entity.CarRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CarRentalRepository extends JpaRepository<CarRental, Long> {
}
