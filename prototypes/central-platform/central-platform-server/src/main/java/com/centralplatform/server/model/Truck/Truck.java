package com.centralplatform.server.model.Truck;

import com.centralplatform.server.model.Item.Item;
import com.centralplatform.server.model.Route.Route;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "truck")
public class Truck {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "maxStorage")
    private Integer maxStorage;


    @OneToMany(mappedBy = "truck")
    @JsonManagedReference(value = "item-truck")
    private List<Item> storage;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference(value = "truck-route")
    private Route route;


}
