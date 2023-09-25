package com.centralplatform.server.controller.Route;

import com.centralplatform.server.dto.Route.RouteDTO;
import com.centralplatform.server.payload.request.Route.RouteRequest;
import com.centralplatform.server.service.Route.RouteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RouteControllerImpl implements RouteController<RouteRequest>{
    private final RouteServiceImpl routeService;

    @Override
    public ResponseEntity<? extends List<RouteDTO>> getInstitutions(RouteRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<? extends RouteDTO> getInstitutionById(String id) {
        return null;
    }

    @Override
    public ResponseEntity<? extends RouteDTO> uploadInstitution(RouteRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<? extends RouteDTO> updateInstitution(RouteRequest request, String id) {
        return null;
    }

    @Override
    public ResponseEntity<? extends List<RouteDTO>> uploadInstitutions(RouteRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteInstitutionById(String id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteInstitutions(RouteRequest request) {
        return null;
    }
}
