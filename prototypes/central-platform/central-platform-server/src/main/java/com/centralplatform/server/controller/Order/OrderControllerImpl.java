package com.centralplatform.server.controller.Order;

import com.centralplatform.server.dto.Order.OrderDTO;
import com.centralplatform.server.payload.request.Order.OrderRequest;
import com.centralplatform.server.service.Order.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderControllerImpl implements OrderController<OrderRequest> {
    private final OrderServiceImpl orderService;

    @Override
    public ResponseEntity<? extends List<OrderDTO>> getInstitutions(OrderRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<? extends OrderDTO> getInstitutionById(String id) {
        return null;
    }

    @Override
    public ResponseEntity<? extends OrderDTO> uploadInstitution(OrderRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<? extends OrderDTO> updateInstitution(OrderRequest request, String id) {
        return null;
    }

    @Override
    public ResponseEntity<? extends List<OrderDTO>> uploadInstitutions(OrderRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteInstitutionById(String id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteInstitutions(OrderRequest request) {
        return null;
    }
}
