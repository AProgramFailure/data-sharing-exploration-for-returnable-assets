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
    public <T extends LocationRequest> ResponseEntity<? extends List<LocationDTO>> getInstitutions(T request) {
        return ResponseEntity.ok(locationService.getLocations(request));
    }

    @Override
    public ResponseEntity<? extends LocationDTO> getInstitutionById(String id) {
        return ResponseEntity.ok(locationService.getLocationById(id));
    }

    @Override
    public <T extends LocationRequest> ResponseEntity<? extends LocationDTO> uploadInstitution(T request) {
        return ResponseEntity.ok(locationService.uploadLocation(request));
    }

    @Override
    public <T extends LocationRequest> ResponseEntity<? extends LocationDTO> updateInstitution(T request, String id) {
        return ResponseEntity.ok(locationService.updateLocation(request,id));
    }

    @Override
    public <T extends LocationRequest> ResponseEntity<? extends List<LocationDTO>> uploadInstitutions(T request) {
        return ResponseEntity.ok(locationService.uploadLocations(request));
    }

    @Override
    public ResponseEntity<?> deleteInstitutionById(String id) {
        locationService.deleteLocationById(id);
        return ResponseEntity.ok("Success");
    }

    @Override
    public <T extends LocationRequest> ResponseEntity<?> deleteInstitutions(T request) {
        locationService.deleteLocations(request);
        return ResponseEntity.ok("Success");
    }
}
