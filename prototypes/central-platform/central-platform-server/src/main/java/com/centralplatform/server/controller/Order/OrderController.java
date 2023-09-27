package com.centralplatform.server.controller.Order;

import com.centralplatform.server.dto.Order.OrderDTO;
import com.centralplatform.server.payload.request.Order.OrderInfoRequest;
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
    ResponseEntity<? extends List<OrderDTO>> getOrders(@RequestBody OrderInfoRequest request);

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    ResponseEntity<? extends OrderDTO> getOrderById(@PathVariable("id") String id);

    // POST
    @RequestMapping(value = "/order/update/{id}", method = RequestMethod.POST)
    ResponseEntity<? extends OrderDTO> updateOrder(@RequestBody R request, @PathVariable("id") String id);

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    ResponseEntity<? extends OrderDTO> uploadOrder(@RequestBody R request);

    @RequestMapping(value = "/order/update", method = RequestMethod.POST)
    ResponseEntity<? extends List<OrderDTO>> uploadOrders(@RequestBody R request);


    // DELETE
    @RequestMapping(value = "/order/delete/{id}", method = RequestMethod.GET)
    ResponseEntity<?> deleteOrderById(@PathVariable("id") String id);

    @RequestMapping(value = "/order/delete", method = RequestMethod.GET)
    ResponseEntity<?> deleteOrders(@RequestBody R request);
}
