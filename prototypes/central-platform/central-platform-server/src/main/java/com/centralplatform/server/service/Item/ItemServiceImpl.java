package com.centralplatform.server.service.Item;

import com.centralplatform.server.dto.Item.ItemDTO;
import com.centralplatform.server.dto.Item.ItemDTOConverter;
import com.centralplatform.server.model.Item.Item;
import com.centralplatform.server.payload.request.Item.ItemRequest;
import com.centralplatform.server.repository.Item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ItemDTOConverter converter;

    @Override
    public List<ItemDTO> getItems(ItemRequest request) {
        return converter.convert(itemRepository.findAll());
    }

    @Override
    public ItemDTO getItemById(String id) {
        return converter.convert(itemRepository.findById(UUID.fromString(id)).orElseThrow());
    }

    @Override
    public ItemDTO uploadItem(ItemRequest request) {
        Item item = Item.builder().build();
        return converter.convert(itemRepository.save(item));
    }

    @Override
    public ItemDTO updateItem(ItemRequest request, String id) {
        return null;
    }

    @Override
    public List<ItemDTO> uploadItems(ItemRequest request) {
        List<Item> itemList = new ArrayList<>();
        return converter.convert(itemList);
    }

    @Override
    public void deleteItemById(String id) {
        itemRepository.delete(itemRepository.findById(UUID.fromString(id)).orElseThrow());
    }

    @Override
    public void deleteItems(ItemRequest request) {
        List<UUID> itemIdList = new ArrayList<>();
        itemRepository.deleteAll(itemRepository.findAllById(itemIdList));
    }
}
