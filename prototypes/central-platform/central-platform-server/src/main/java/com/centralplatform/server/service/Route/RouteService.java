package com.centralplatform.server.service.Route;

import com.centralplatform.server.dto.Route.RouteDTO;
import com.centralplatform.server.payload.request.Route.RouteRequest;

import java.util.List;

public interface RouteService<R extends RouteRequest> {
    List<RouteDTO> getRoutes(R request);

    RouteDTO getRouteById(String id);

    RouteDTO uploadRoute(R request);

    RouteDTO updateRoute(R request, String id);

    List<RouteDTO> uploadRoutes(R request);

    void deleteRouteById(String id);

    void deleteRoutes(R request);
}
