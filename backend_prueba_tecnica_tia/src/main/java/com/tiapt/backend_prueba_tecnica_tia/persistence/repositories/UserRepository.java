package com.tiapt.backend_prueba_tecnica_tia.persistence.repositories;

import java.util.Optional;

import com.tiapt.backend_prueba_tecnica_tia.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByDNI(String DNI);
}
