package com.centralplatform.server.repository.Institution;

import com.centralplatform.server.model.Institution.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, UUID> {


    @Modifying
    @Query(nativeQuery = true, value = "update intitution set name = ?2 where id = ?1")
    Optional<Institution> updateInstitution(UUID id, String name);
}
