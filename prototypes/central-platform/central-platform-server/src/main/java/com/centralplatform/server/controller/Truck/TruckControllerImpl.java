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
    public ResponseEntity<? extends List<TruckDTO>> getTrucks(TruckInfoRequest request) {
        return ResponseEntity.ok(truckService.getTrucks(request));
    }

    @Override
    public ResponseEntity<? extends TruckDTO> getTruckById(String id) {
        return ResponseEntity.ok(truckService.getTruckById(id));
    }

    @Override
    public ResponseEntity<? extends TruckDTO> uploadTruck(TruckRequest request) {
        return ResponseEntity.ok(truckService.uploadTruck(request));
    }

    @Override
    public ResponseEntity<? extends TruckDTO> updateTruck(TruckRequest request, String id) {
        return ResponseEntity.ok(truckService.updateTruck(request,id));
    }

    @Override
    public ResponseEntity<? extends List<TruckDTO>> uploadTrucks(TruckRequest request) {
        return ResponseEntity.ok(truckService.uploadTrucks(request));
    }

    @Override
    public ResponseEntity<?> deleteTruckById(String id) {
        truckService.deleteTruckById(id);
        return ResponseEntity.ok("Successfully Deleted");
    }

    @Override
    public ResponseEntity<?> deleteTrucks(TruckRequest request) {
        truckService.deleteTrucks(request);
        return ResponseEntity.ok("Successfully Deleted");
    }
}
