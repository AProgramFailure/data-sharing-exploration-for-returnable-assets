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
    public ResponseEntity<? extends List<ItemDTO>> getInstitutions(ItemInfoRequest request) {
        return ResponseEntity.ok(itemService.getItems(request));
    }

    @Override
    public ResponseEntity<? extends ItemDTO> getInstitutionById(String id) {
        return ResponseEntity.ok(itemService.getItemById(id));
    }

    @Override
    public ResponseEntity<? extends ItemDTO> uploadInstitution(ItemRequest request) {
        return ResponseEntity.ok(itemService.uploadItem(request));
    }

    @Override
    public ResponseEntity<? extends ItemDTO> updateInstitution(ItemRequest request, String id) {
        return ResponseEntity.ok(itemService.updateItem(request, id));
    }

    @Override
    public ResponseEntity<? extends List<ItemDTO>> uploadInstitutions(ItemRequest request) {
        return ResponseEntity.ok(itemService.uploadItems(request));
    }

    @Override
    public ResponseEntity<?> deleteInstitutionById(String id) {
        itemService.deleteItemById(id);
        return ResponseEntity.ok("Successfully Deleted");
    }

    @Override
    public ResponseEntity<?> deleteInstitutions(ItemRequest request) {
        itemService.deleteItems(request);
        return ResponseEntity.ok("Successfully Deleted");
    }
}
