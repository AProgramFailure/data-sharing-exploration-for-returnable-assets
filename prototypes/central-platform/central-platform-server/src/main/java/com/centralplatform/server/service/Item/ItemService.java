package com.centralplatform.server.service.Item;


import com.centralplatform.server.dto.Item.ItemDTO;
import com.centralplatform.server.payload.request.Item.ItemRequest;

import java.util.List;

public interface ItemService<R extends ItemRequest> {

    List<ItemDTO> getItems(R request);

    ItemDTO getItemById(String id);

    ItemDTO uploadItem(R request);

    ItemDTO updateItem(R request, String id);

    List<ItemDTO> uploadItems(R request);

    void deleteItemById(String id);

    void deleteItems(R request);
}
