package com.angular.spring.tfg.teamfighttacticssearch.security.repository;

import com.angular.spring.tfg.teamfighttacticssearch.security.entity.Rol;
import com.angular.spring.tfg.teamfighttacticssearch.security.enums.RolName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolName(RolName rolName);
}
