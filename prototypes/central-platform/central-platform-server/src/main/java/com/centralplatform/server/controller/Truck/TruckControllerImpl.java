package com.centralplatform.server.controller.Truck;

import com.centralplatform.server.dto.Truck.TruckDTO;
import com.centralplatform.server.payload.request.Truck.TruckInfoRequest;
import com.centralplatform.server.payload.request.Truck.TruckRequest;
import com.centralplatform.server.service.Truck.TruckServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/prod")
@RequiredArgsConstructor
public class TruckControllerImpl implements TruckController<TruckRequest>{
    private final TruckServiceImpl truckService;

    @Override
    public <T extends TruckRequest> ResponseEntity<? extends List<TruckDTO>> getTrucks(T request) {
        return ResponseEntity.ok(truckService.getTrucks(request));
    }

    @Override
    public ResponseEntity<? extends TruckDTO> getTruckById(String id) {
        return ResponseEntity.ok(truckService.getTruckById(id));
    }

    @Override
    public <T extends TruckRequest> ResponseEntity<? extends TruckDTO> uploadTruck(T request) {
        return ResponseEntity.ok(truckService.uploadTruck(request));
    }

    @Override
    public <T extends TruckRequest> ResponseEntity<? extends TruckDTO> updateTruck(T request, String id) {
        return ResponseEntity.ok(truckService.updateTruck(request,id));
    }

    @Override
    public <T extends TruckRequest> ResponseEntity<? extends List<TruckDTO>> uploadTrucks(T request) {
        return ResponseEntity.ok(truckService.uploadTrucks(request));
    }

    @Override
    public ResponseEntity<?> deleteTruckById(String id) {
        truckService.deleteTruckById(id);
        return ResponseEntity.ok("Success");
    }

    @Override
    public <T extends TruckRequest> ResponseEntity<?> deleteTrucks(T request) {
        truckService.deleteTrucks(request);
        return ResponseEntity.ok("Success");
    }
}
