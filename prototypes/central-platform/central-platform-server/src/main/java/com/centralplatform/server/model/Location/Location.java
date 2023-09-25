package com.centralplatform.server.model.Location;

import com.centralplatform.server.model.Institution.Institution;
import com.centralplatform.server.model.Item.Item;
import com.centralplatform.server.model.Route.Route;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "location")
public class Location {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "address")
    private String address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "_institution_id", nullable = false)
    private Institution institution;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "items")
    @OneToMany(mappedBy = "location")
    private List<Item> items;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Route route;


}
