package com.centralplatform.server.repository.Truck;

import com.centralplatform.server.model.Truck.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TruckRepository extends JpaRepository<Truck, UUID> {
}
