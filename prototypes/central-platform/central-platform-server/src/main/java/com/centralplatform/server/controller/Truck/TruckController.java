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
    <T extends R> ResponseEntity<? extends List<TruckDTO>> getTrucks(@RequestBody T request);

    @RequestMapping(value = "/truck/{id}", method = RequestMethod.GET)
    ResponseEntity<? extends TruckDTO> getTruckById(@PathVariable("id") String id);

    // POST
    @RequestMapping(value = "/truck", method = RequestMethod.POST)
    <T extends R> ResponseEntity<? extends TruckDTO> uploadTruck(@RequestBody T request);

    @RequestMapping(value = "/truck/update/{id}", method = RequestMethod.POST)
    <T extends R> ResponseEntity<? extends TruckDTO> updateTruck(@RequestBody T request, @PathVariable("id") String id);

    @RequestMapping(value = "/truck/update", method = RequestMethod.POST)
    <T extends R> ResponseEntity<? extends List<TruckDTO>> uploadTrucks(@RequestBody T request);


    // DELETE
    @RequestMapping(value = "/truck/delete/{id}", method = RequestMethod.GET)
    ResponseEntity<?> deleteTruckById(@PathVariable("id") String id);

    @RequestMapping(value = "/truck/delete", method = RequestMethod.GET)
    <T extends R> ResponseEntity<?> deleteTrucks(@RequestBody T request);
}
