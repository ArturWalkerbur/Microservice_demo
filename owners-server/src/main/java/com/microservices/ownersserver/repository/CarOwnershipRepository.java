package com.microservices.ownersserver.repository;



import com.microservices.ownersserver.entity.CarOwnership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CarOwnershipRepository extends JpaRepository<CarOwnership, Long> {
}
