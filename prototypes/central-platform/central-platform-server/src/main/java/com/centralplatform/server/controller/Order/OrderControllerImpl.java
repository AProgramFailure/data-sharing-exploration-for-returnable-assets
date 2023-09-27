package com.centralplatform.server.controller.Order;

import com.centralplatform.server.dto.Order.OrderDTO;
import com.centralplatform.server.payload.request.Order.OrderInfoRequest;
import com.centralplatform.server.payload.request.Order.OrderRequest;
import com.centralplatform.server.service.Order.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/prod")
@RequiredArgsConstructor
public class OrderControllerImpl implements OrderController<OrderRequest> {
    private final OrderServiceImpl orderService;

    @Override
    public ResponseEntity<? extends List<OrderDTO>> getOrders(OrderInfoRequest request) {
        return ResponseEntity.ok(orderService.getOrders(request));
    }

    @Override
    public ResponseEntity<? extends OrderDTO> getOrderById(String id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @Override
    public ResponseEntity<? extends OrderDTO> updateOrder(OrderRequest request, String id) {
        return ResponseEntity.ok(orderService.updateOrder(request, id));
    }

    @Override
    public ResponseEntity<? extends OrderDTO> uploadOrder(OrderRequest request) {
        return ResponseEntity.ok(orderService.uploadOrder(request));
    }

    @Override
    public ResponseEntity<? extends List<OrderDTO>> uploadOrders(OrderRequest request) {
        return ResponseEntity.ok(orderService.uploadOrders(request));
    }

    @Override
    public ResponseEntity<?> deleteOrderById(String id) {
        orderService.deleteOrderById(id);
        return ResponseEntity.ok("Successfully Deleted");
    }

    @Override
    public ResponseEntity<?> deleteOrders(OrderRequest request) {
        orderService.deleteOrders(request);
        return ResponseEntity.ok("Successfully Deleted");
    }
}
