package com.centralplatform.server.service.Truck;

import com.centralplatform.server.repository.Truck.TruckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TruckServiceImpl implements TruckService {
    private final TruckRepository truckRepository;
}
