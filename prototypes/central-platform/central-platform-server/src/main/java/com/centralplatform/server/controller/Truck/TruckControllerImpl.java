package com.centralplatform.server.controller.Truck;

import com.centralplatform.server.dto.Truck.TruckDTO;
import com.centralplatform.server.payload.request.Truck.TruckRequest;
import com.centralplatform.server.service.Truck.TruckServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TruckControllerImpl implements TruckController<TruckRequest>{
    private final TruckServiceImpl truckService;

    @Override
    public ResponseEntity<? extends List<TruckDTO>> getInstitutions(TruckRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<? extends TruckDTO> getInstitutionById(String id) {
        return null;
    }

    @Override
    public ResponseEntity<? extends TruckDTO> uploadInstitution(TruckRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<? extends TruckDTO> updateInstitution(TruckRequest request, String id) {
        return null;
    }

    @Override
    public ResponseEntity<? extends List<TruckDTO>> uploadInstitutions(TruckRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteInstitutionById(String id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteInstitutions(TruckRequest request) {
        return null;
    }
}
