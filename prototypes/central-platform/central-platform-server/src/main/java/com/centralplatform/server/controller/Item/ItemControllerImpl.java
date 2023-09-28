package com.centralplatform.server.controller.Item;

import com.centralplatform.server.dto.Item.ItemDTO;
import com.centralplatform.server.payload.request.Item.ItemInfoRequest;
import com.centralplatform.server.payload.request.Item.ItemRequest;
import com.centralplatform.server.service.Item.ItemServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/prod")
@RequiredArgsConstructor
public class ItemControllerImpl implements ItemController<ItemRequest> {
    private final ItemServiceImpl itemService;

    @Override
    public <T extends ItemRequest> ResponseEntity<? extends List<ItemDTO>> getItems(T request) {
        return ResponseEntity.ok(itemService.getItems(request));
    }

    @Override
    public ResponseEntity<? extends ItemDTO> getItemById(String id) {
        return ResponseEntity.ok(itemService.getItemById(id));
    }

    @Override
    public <T extends ItemRequest> ResponseEntity<? extends ItemDTO> uploadItem(T request) {
        return ResponseEntity.ok(itemService.uploadItem(request));
    }

    @Override
    public <T extends ItemRequest> ResponseEntity<? extends ItemDTO> updateItem(T request, String id) {
        return ResponseEntity.ok(itemService.updateItem(request,id));
    }

    @Override
    public <T extends ItemRequest> ResponseEntity<? extends List<ItemDTO>> uploadItems(T request) {
        return ResponseEntity.ok(itemService.uploadItems(request));
    }

    @Override
    public ResponseEntity<?> deleteItemById(String id) {
        itemService.deleteItemById(id);
        return ResponseEntity.ok("Success");
    }

    @Override
    public <T extends ItemRequest> ResponseEntity<?> deleteItems(T request) {
        itemService.deleteItems(request);
        return ResponseEntity.ok("Success");
    }
}
