package com.centralplatform.server.service.Route;

import com.centralplatform.server.dto.Route.RouteDTO;
import com.centralplatform.server.dto.Route.RouteDTOConverter;
import com.centralplatform.server.model.Route.Route;
import com.centralplatform.server.payload.request.Route.RouteRequest;
import com.centralplatform.server.repository.Route.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final RouteDTOConverter converter;

    @Override
    public List<RouteDTO> getRoutes(RouteRequest request) {
        return converter.convert(routeRepository.findAll());
    }

    @Override
    public RouteDTO getRouteById(String id) {
        return converter.convert(routeRepository.findById(UUID.fromString(id)).orElseThrow());
    }

    @Override
    public RouteDTO uploadRoute(RouteRequest request) {
        Route route = Route.builder().build();
        return converter.convert(routeRepository.save(route));
    }

    @Override
    public RouteDTO updateRoute(RouteRequest request, String id) {
        return null;
    }

    @Override
    public List<RouteDTO> uploadRoutes(RouteRequest request) {
        List<Route> routeList = new ArrayList<>();
        return converter.convert(routeList);
    }

    @Override
    public void deleteRouteById(String id) {
        routeRepository.delete(routeRepository.findById(UUID.fromString(id)).orElseThrow());
    }

    @Override
    public void deleteRoutes(RouteRequest request) {
        List<UUID> institutionIdList = new ArrayList<>();
        routeRepository.deleteAll(routeRepository.findAllById(institutionIdList));

    }
}
