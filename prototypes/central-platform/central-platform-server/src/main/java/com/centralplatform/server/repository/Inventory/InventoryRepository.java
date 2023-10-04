package com.centralplatform.server.repository.Inventory;

import com.centralplatform.server.model.Order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InventoryRepository extends JpaRepository<Order, UUID> {
}
