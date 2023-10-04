package com.centralplatform.server.model.Order;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @UuidGenerator
    private UUID id;
    private String brand;
    private int requestedQuantity;
    private int actualQuantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
