package com.centralplatform.server.model.Order;

import com.centralplatform.server.model.Institution.Institution;
import com.centralplatform.server.model.Item.Item;
import com.centralplatform.server.model.Route.Route;
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
@Table(name = "_order")
public class Order {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "amount")
    @OneToMany(mappedBy = "order")
    @JsonManagedReference
    private List<Item> amount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "institution_id", referencedColumnName = "id")
    private Institution institution;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    private Route route;
}
