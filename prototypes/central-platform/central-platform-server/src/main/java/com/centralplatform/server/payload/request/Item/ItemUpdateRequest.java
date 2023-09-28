package com.centralplatform.server.payload.request.Item;

import com.centralplatform.server.model.Item.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ItemUpdateRequest extends ItemRequest {

    Item item;
}
