package com.centralplatform.server.repository.Item;

import com.centralplatform.server.model.Item.Item;
import com.centralplatform.server.model.Item.ItemType;
import com.centralplatform.server.model.Location.Location;
import com.centralplatform.server.model.Order.Order;
import com.centralplatform.server.model.Truck.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {


    @Modifying
    @Query(nativeQuery = true, value = "update item set name = ?2, type = ?3, capacity = ?4, barcode = ?5, location = ?6 where id = ?1")
    Optional<Item> updateItem(UUID id, String name, ItemType type, Integer capacity, String barcode, Location location, Truck truck, Order order);

}
