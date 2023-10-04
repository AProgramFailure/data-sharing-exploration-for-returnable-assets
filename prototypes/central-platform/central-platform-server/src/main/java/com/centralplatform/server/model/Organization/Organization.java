package com.centralplatform.server.model.Organization;

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
@Table(name = "organization")
public class Organization {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    private OrganizationType organizationType;

    @Column(name = "location")
    @OneToMany(mappedBy = "organization")
    @JsonManagedReference(value = "organization-location")
    private List<Location> locations;


    @JsonManagedReference(value = "organization-order")
    @OneToMany(mappedBy = "organization")
    private List<Order> orders;
}
