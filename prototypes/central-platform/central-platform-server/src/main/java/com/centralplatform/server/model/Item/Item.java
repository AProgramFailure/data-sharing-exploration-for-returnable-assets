package com.centralplatform.server.model.Item;


import com.centralplatform.server.model.Location.Location;
import com.centralplatform.server.model.Order.Order;
import com.centralplatform.server.model.Truck.Truck;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "item")
public class Item {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private ItemType type;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "barcode")
    private String barcode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Location location;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Truck truck;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Order order;
}
