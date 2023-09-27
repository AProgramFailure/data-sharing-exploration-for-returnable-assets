package com.centralplatform.server.service.Truck;

import com.centralplatform.server.dto.Truck.TruckDTO;
import com.centralplatform.server.payload.request.Truck.TruckRequest;

import java.util.List;

public interface TruckService<R extends TruckRequest> {

    List<TruckDTO> getTrucks(R request);

    TruckDTO getTruckById(String id);

    TruckDTO uploadTruck(R request);

    TruckDTO updateTruck(R request, String id);

    List<TruckDTO> uploadTrucks(R request);

    void deleteTruckById(String id);

    void deleteTrucks(R request);
}
