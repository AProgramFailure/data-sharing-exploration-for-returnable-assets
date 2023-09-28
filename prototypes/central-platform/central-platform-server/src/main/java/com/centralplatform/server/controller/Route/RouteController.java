package com.centralplatform.server.controller.Route;

import com.centralplatform.server.dto.Route.RouteDTO;
import com.centralplatform.server.payload.request.Route.RouteInfoRequest;
import com.centralplatform.server.payload.request.Route.RouteRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface RouteController<R extends RouteRequest> {
    // GET
    @RequestMapping(value = "/route", method = RequestMethod.GET)
    <T extends R>ResponseEntity<? extends List<RouteDTO>> getRoutes(@RequestBody T request);

    @RequestMapping(value = "/route/{id}", method = RequestMethod.GET)
    ResponseEntity<? extends RouteDTO> getRoutesById(@PathVariable("id") String id);

    // POST
    @RequestMapping(value = "/route", method = RequestMethod.POST)
    <T extends R> ResponseEntity<? extends RouteDTO> uploadRoute(@RequestBody T request);

    @RequestMapping(value = "/route/update/{id}", method = RequestMethod.POST)
    <T extends R> ResponseEntity<? extends RouteDTO> updateRoute(@RequestBody T request, @PathVariable("id") String id);

    @RequestMapping(value = "/route/update", method = RequestMethod.POST)
    <T extends R> ResponseEntity<? extends List<RouteDTO>> uploadRoutes(@RequestBody T request);


    // DELETE
    @RequestMapping(value = "/route/delete/{id}", method = RequestMethod.GET)
    ResponseEntity<?> deleteRouteById(@PathVariable("id") String id);

    @RequestMapping(value = "/route/delete", method = RequestMethod.GET)
    <T extends R> ResponseEntity<?> deleteRoutes(@RequestBody T request);
}
