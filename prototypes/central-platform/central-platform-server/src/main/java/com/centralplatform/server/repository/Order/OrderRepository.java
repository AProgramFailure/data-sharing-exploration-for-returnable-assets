package com.centralplatform.server.repository.Order;

import com.centralplatform.server.model.Institution.Institution;
import com.centralplatform.server.model.Item.Item;
import com.centralplatform.server.model.Order.Order;
import com.centralplatform.server.model.Route.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

    @Modifying
    @Query(nativeQuery = true, value = "update order set amount = ?2, institution = ?3, route = ?4, where id = ?1")
    Optional<Order> updateOrder(UUID id, List<Item> amount, Institution institution, Route route);
}
