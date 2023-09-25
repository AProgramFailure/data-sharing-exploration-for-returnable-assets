package com.centralplatform.server.controller.Route;

import com.centralplatform.server.dto.Route.RouteDTO;
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
    ResponseEntity<? extends List<RouteDTO>> getInstitutions(@RequestBody R request);

    @RequestMapping(value = "/route/{id}", method = RequestMethod.GET)
    ResponseEntity<? extends RouteDTO> getInstitutionById(@PathVariable("id") String id);

    // POST
    @RequestMapping(value = "/route", method = RequestMethod.POST)
    ResponseEntity<? extends RouteDTO> uploadInstitution(@RequestBody R request);

    @RequestMapping(value = "/route/update/{id}", method = RequestMethod.POST)
    ResponseEntity<? extends RouteDTO> updateInstitution(@RequestBody R request, @PathVariable("id") String id);

    @RequestMapping(value = "/route/update", method = RequestMethod.POST)
    ResponseEntity<? extends List<RouteDTO>> uploadInstitutions(@RequestBody R request);


    // DELETE
    @RequestMapping(value = "/route/delete/{id}", method = RequestMethod.GET)
    ResponseEntity<?> deleteInstitutionById(@PathVariable("id") String id);

    @RequestMapping(value = "/route/delete", method = RequestMethod.GET)
    ResponseEntity<?> deleteInstitutions(@RequestBody R request);
}
