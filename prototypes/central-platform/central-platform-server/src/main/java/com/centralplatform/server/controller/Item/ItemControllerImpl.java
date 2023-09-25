package com.centralplatform.server.controller.Item;

import com.centralplatform.server.dto.Item.ItemDTO;
import com.centralplatform.server.payload.request.Item.ItemRequest;
import com.centralplatform.server.service.Item.ItemServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemControllerImpl implements ItemController<ItemRequest> {
    private final ItemServiceImpl itemService;

    @Override
    public ResponseEntity<? extends List<ItemDTO>> getInstitutions(ItemRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<? extends ItemDTO> getInstitutionById(String id) {
        return null;
    }

    @Override
    public ResponseEntity<? extends ItemDTO> uploadInstitution(ItemRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<? extends ItemDTO> updateInstitution(ItemRequest request, String id) {
        return null;
    }

    @Override
    public ResponseEntity<? extends List<ItemDTO>> uploadInstitutions(ItemRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteInstitutionById(String id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteInstitutions(ItemRequest request) {
        return null;
    }
}
