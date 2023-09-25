package com.centralplatform.server.model.Institution;

import com.centralplatform.server.model.Location.Location;
import com.centralplatform.server.model.Order.Order;
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
@Table(name = "institution")
public class Institution {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    @OneToMany(mappedBy = "institution")
    @JsonManagedReference
    private List<Location> locations;

    @OneToOne(mappedBy = "institution")
    private Order order;
}
