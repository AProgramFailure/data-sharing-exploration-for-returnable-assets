package com.centralplatform.server.controller.Route;

import com.centralplatform.server.dto.Route.RouteDTO;
import com.centralplatform.server.payload.request.Route.RouteInfoRequest;
import com.centralplatform.server.payload.request.Route.RouteRequest;
import com.centralplatform.server.service.Route.RouteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/prod")
@RequiredArgsConstructor
public class RouteControllerImpl implements RouteController<RouteRequest>{
    private final RouteServiceImpl routeService;

    @Override
    public ResponseEntity<? extends List<RouteDTO>> getRoutes(RouteInfoRequest request) {
        return ResponseEntity.ok(routeService.getRoutes(request));
    }

    @Override
    public ResponseEntity<? extends RouteDTO> getRoutesById(String id) {
        return ResponseEntity.ok(routeService.getRouteById(id));
    }

    @Override
    public ResponseEntity<? extends RouteDTO> uploadRoute(RouteRequest request) {
        return ResponseEntity.ok(routeService.uploadRoute(request));
    }

    @Override
    public ResponseEntity<? extends RouteDTO> updateRoute(RouteRequest request, String id) {
        return ResponseEntity.ok(routeService.updateRoute(request, id));
    }

    @Override
    public ResponseEntity<? extends List<RouteDTO>> uploadRoutes(RouteRequest request) {
        return ResponseEntity.ok(routeService.uploadRoutes(request));
    }

    @Override
    public ResponseEntity<?> deleteRouteById(String id) {
        routeService.deleteRouteById(id);
        return ResponseEntity.ok("Successfully Deleted");
    }

    @Override
    public ResponseEntity<?> deleteRoutes(RouteRequest request) {
        routeService.deleteRoutes(request);
        return ResponseEntity.ok("Successfully Deleted");
    }
}
