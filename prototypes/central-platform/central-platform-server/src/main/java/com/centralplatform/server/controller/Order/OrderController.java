package com.centralplatform.server.controller.Order;

import com.centralplatform.server.dto.Order.OrderDTO;
import com.centralplatform.server.payload.request.Order.OrderRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface OrderController<R extends OrderRequest> {
    // GET
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    ResponseEntity<? extends List<OrderDTO>> getInstitutions(@RequestBody R request);

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    ResponseEntity<? extends OrderDTO> getInstitutionById(@PathVariable("id") String id);

    // POST
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    ResponseEntity<? extends OrderDTO> uploadInstitution(@RequestBody R request);

    @RequestMapping(value = "/order/update/{id}", method = RequestMethod.POST)
    ResponseEntity<? extends OrderDTO> updateInstitution(@RequestBody R request, @PathVariable("id") String id);

    @RequestMapping(value = "/order/update", method = RequestMethod.POST)
    ResponseEntity<? extends List<OrderDTO>> uploadInstitutions(@RequestBody R request);


    // DELETE
    @RequestMapping(value = "/order/delete/{id}", method = RequestMethod.GET)
    ResponseEntity<?> deleteInstitutionById(@PathVariable("id") String id);

    @RequestMapping(value = "/order/delete", method = RequestMethod.GET)
    ResponseEntity<?> deleteInstitutions(@RequestBody R request);
}
