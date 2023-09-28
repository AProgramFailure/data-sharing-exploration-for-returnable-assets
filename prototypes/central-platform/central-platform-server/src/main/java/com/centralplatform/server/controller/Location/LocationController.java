package com.centralplatform.server.controller.Location;

import com.centralplatform.server.dto.Location.LocationDTO;
import com.centralplatform.server.payload.request.Location.LocationInfoRequest;
import com.centralplatform.server.payload.request.Location.LocationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface LocationController<R extends LocationRequest>{

    // GET
    @RequestMapping(value = "/location", method = RequestMethod.GET)
    <T extends R>ResponseEntity<? extends List<LocationDTO>> getInstitutions(@RequestBody T request);

    @RequestMapping(value = "/location/{id}", method = RequestMethod.GET)
    ResponseEntity<? extends LocationDTO> getInstitutionById(@PathVariable("id") String id);

    // POST
    @RequestMapping(value = "/location", method = RequestMethod.POST)
    <T extends R>ResponseEntity<? extends LocationDTO> uploadInstitution(@RequestBody T request);

    @RequestMapping(value = "/location/update/{id}", method = RequestMethod.POST)
    <T extends R>ResponseEntity<? extends LocationDTO> updateInstitution(@RequestBody T request, @PathVariable("id") String id);

    @RequestMapping(value = "/location/update", method = RequestMethod.POST)
    <T extends R>ResponseEntity<? extends List<LocationDTO>> uploadInstitutions(@RequestBody T request);


    // DELETE
    @RequestMapping(value = "/location/delete/{id}", method = RequestMethod.GET)
    ResponseEntity<?> deleteInstitutionById(@PathVariable("id") String id);

    @RequestMapping(value = "/location/delete", method = RequestMethod.GET)
    <T extends R>ResponseEntity<?> deleteInstitutions(@RequestBody T request);
}
