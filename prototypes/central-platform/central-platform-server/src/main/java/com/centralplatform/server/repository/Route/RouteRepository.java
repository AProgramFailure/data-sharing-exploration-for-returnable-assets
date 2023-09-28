package com.centralplatform.server.repository.Route;

import com.centralplatform.server.model.Location.Location;
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
public interface RouteRepository extends JpaRepository<Route, UUID> {


    @Modifying
    @Query(nativeQuery = true, value = "update item set isFull = ?2, isContainingReturnable = ?3, locations = ?4, trucks = ?5 where id = ?1")
    Optional<Route> updateRoute(UUID id, Boolean isFull, Boolean isContainingReturnable, List<Location> locations, List<Truck> trucks);
}
