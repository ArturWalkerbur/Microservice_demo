package com.microservices.authserver.repository;


import com.microservices.authserver.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {

    @Query("select r from Roles r where r.name = 'USER'")
    Roles findRoleUser();

}
