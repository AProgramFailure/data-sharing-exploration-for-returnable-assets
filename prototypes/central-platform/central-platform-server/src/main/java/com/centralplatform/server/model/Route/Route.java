package com.centralplatform.server.model.Route;

import com.centralplatform.server.model.Location.Location;
import com.centralplatform.server.model.Truck.Truck;
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
@Table(name = "route")
public class Route {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "isFull")
    private Boolean isFull;

    @Column(name = "isContainingReturnable")
    private Boolean isContainingReturnable;


    @OneToMany(mappedBy = "route")
    @JsonManagedReference
    private List<Location> locations;


    @OneToMany(mappedBy = "route")
    private List<Truck> trucks;

}
