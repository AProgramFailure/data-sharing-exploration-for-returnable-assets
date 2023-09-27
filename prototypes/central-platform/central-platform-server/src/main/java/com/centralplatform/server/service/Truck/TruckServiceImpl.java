package com.centralplatform.server.service.Truck;

import com.centralplatform.server.dto.Truck.TruckDTO;
import com.centralplatform.server.dto.Truck.TruckDTOConverter;
import com.centralplatform.server.model.Truck.Truck;
import com.centralplatform.server.payload.request.Truck.TruckRequest;
import com.centralplatform.server.repository.Truck.TruckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class TruckServiceImpl implements TruckService {

    private final TruckRepository truckRepository;
    private final TruckDTOConverter converter;

    @Override
    public List<TruckDTO> getTrucks(TruckRequest request) {
        return converter.convert(truckRepository.findAll());
    }

    @Override
    public TruckDTO getTruckById(String id) {
        return converter.convert(truckRepository.findById(UUID.fromString(id)).orElseThrow());

    }

    @Override
    public TruckDTO uploadTruck(TruckRequest request) {
        Truck truck = Truck.builder().build();
        return converter.convert(truckRepository.save(truck));
    }

    @Override
    public TruckDTO updateTruck(TruckRequest request, String id) {
        return null;
    }

    @Override
    public List<TruckDTO> uploadTrucks(TruckRequest request) {
        List<Truck> truckList = new ArrayList<>();
        return converter.convert(truckList);
    }

    @Override
    public void deleteTruckById(String id) {
        truckRepository.delete(truckRepository.findById(UUID.fromString(id)).orElseThrow());
    }

    @Override
    public void deleteTrucks(TruckRequest request) {
        List<UUID> institutionIdList = new ArrayList<>();
        truckRepository.deleteAll(truckRepository.findAllById(institutionIdList));
    }
}
