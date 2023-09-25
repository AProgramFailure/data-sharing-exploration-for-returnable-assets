package com.centralplatform.server.controller.Location;

import com.centralplatform.server.dto.Location.LocationDTO;
import com.centralplatform.server.payload.request.Location.LocationRequest;
import com.centralplatform.server.service.Location.LocationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LocationControllerImpl implements LocationController<LocationRequest> {
    private final LocationServiceImpl locationService;

    @Override
    public ResponseEntity<? extends List<LocationDTO>> getInstitutions(LocationRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<? extends LocationDTO> getInstitutionById(String id) {
        return null;
    }

    @Override
    public ResponseEntity<? extends LocationDTO> uploadInstitution(LocationRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<? extends LocationDTO> updateInstitution(LocationRequest request, String id) {
        return null;
    }

    @Override
    public ResponseEntity<? extends List<LocationDTO>> uploadInstitutions(LocationRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteInstitutionById(String id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteInstitutions(LocationRequest request) {
        return null;
    }
}
