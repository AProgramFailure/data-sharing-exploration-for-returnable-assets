package com.centralplatform.server.repository.Truck;

import com.centralplatform.server.model.Item.Item;
import com.centralplatform.server.model.Route.Route;
import com.centralplatform.server.model.Truck.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TruckRepository extends JpaRepository<Truck, UUID> {

    @Modifying
    @Query(nativeQuery = true, value = "update truck set name = ?2, maxStorage = ?3, storage = ?4, route = ?5 where id = ?1")
    Optional<Truck> updateTruck(UUID id, String name, Integer maxStorage, List<Item> storage, Route route);
}
