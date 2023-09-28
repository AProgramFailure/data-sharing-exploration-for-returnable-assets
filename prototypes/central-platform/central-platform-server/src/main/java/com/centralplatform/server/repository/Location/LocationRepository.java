package com.centralplatform.server.repository.Location;

import com.centralplatform.server.model.Institution.Institution;
import com.centralplatform.server.model.Item.Item;
import com.centralplatform.server.model.Location.Location;
import com.centralplatform.server.model.Route.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LocationRepository extends JpaRepository<Location, UUID> {

    @Modifying
    @Query(nativeQuery = true, value = "update location set address = ?2, institution = ?3, latitude = ?4, longitude = ?5, items = ?6, route = ?7 where id = ?1")
    Optional<Location> updateLocation(UUID id, String address, Institution institution, String latitude, String longitude, List<Item> items, Route route);
}
