package com.centralplatform.server.controller.Location;

import com.centralplatform.server.dto.Location.LocationDTO;
import com.centralplatform.server.payload.request.Location.LocationInfoRequest;
import com.centralplatform.server.payload.request.Location.LocationRequest;
import com.centralplatform.server.service.Location.LocationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/prod")
@RequiredArgsConstructor
public class LocationControllerImpl implements LocationController<LocationRequest> {
    private final LocationServiceImpl locationService;

    @Override
    public ResponseEntity<? extends List<LocationDTO>> getInstitutions(LocationInfoRequest request) {
        return ResponseEntity.ok(locationService.getLocations(request));
    }

    @Override
    public ResponseEntity<? extends LocationDTO> getInstitutionById(String id) {
        return ResponseEntity.ok(locationService.getLocationById(id));
    }

    @Override
    public ResponseEntity<? extends LocationDTO> uploadInstitution(LocationRequest request) {
        return ResponseEntity.ok(locationService.uploadLocation(request));
    }

    @Override
    public ResponseEntity<? extends LocationDTO> updateInstitution(LocationRequest request, String id) {
        return ResponseEntity.ok(locationService.updateLocation(request, id));
    }

    @Override
    public ResponseEntity<? extends List<LocationDTO>> uploadInstitutions(LocationRequest request) {
        return ResponseEntity.ok(locationService.uploadLocations(request));
    }

    @Override
    public ResponseEntity<?> deleteInstitutionById(String id) {
        locationService.deleteLocationById(id);
        return ResponseEntity.ok("Successfully Deleted");
    }

    @Override
    public ResponseEntity<?> deleteInstitutions(LocationRequest request) {
        locationService.deleteLocations(request);
        return ResponseEntity.ok("Successfully Deleted");
    }
}
