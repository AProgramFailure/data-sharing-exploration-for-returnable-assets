package com.centralplatform.server.controller.Truck;

import com.centralplatform.server.dto.Truck.TruckDTO;
import com.centralplatform.server.payload.request.Truck.TruckInfoRequest;
import com.centralplatform.server.payload.request.Truck.TruckRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface TruckController<R extends TruckRequest> {
    // GET
    @RequestMapping(value = "/truck", method = RequestMethod.GET)
    ResponseEntity<? extends List<TruckDTO>> getTrucks(@RequestBody TruckInfoRequest request);

    @RequestMapping(value = "/truck/{id}", method = RequestMethod.GET)
    ResponseEntity<? extends TruckDTO> getTruckById(@PathVariable("id") String id);

    // POST
    @RequestMapping(value = "/truck", method = RequestMethod.POST)
    ResponseEntity<? extends TruckDTO> uploadTruck(@RequestBody R request);

    @RequestMapping(value = "/truck/update/{id}", method = RequestMethod.POST)
    ResponseEntity<? extends TruckDTO> updateTruck(@RequestBody R request, @PathVariable("id") String id);

    @RequestMapping(value = "/truck/update", method = RequestMethod.POST)
    ResponseEntity<? extends List<TruckDTO>> uploadTrucks(@RequestBody R request);


    // DELETE
    @RequestMapping(value = "/truck/delete/{id}", method = RequestMethod.GET)
    ResponseEntity<?> deleteTruckById(@PathVariable("id") String id);

    @RequestMapping(value = "/truck/delete", method = RequestMethod.GET)
    ResponseEntity<?> deleteTrucks(@RequestBody R request);
}