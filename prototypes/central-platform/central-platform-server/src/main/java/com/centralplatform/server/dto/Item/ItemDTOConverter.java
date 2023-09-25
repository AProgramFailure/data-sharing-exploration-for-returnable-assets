package com.centralplatform.server.dto.Item;

import com.centralplatform.server.model.Item.Item;
import com.centralplatform.server.util.Converters.GenericConverter;

import java.util.List;
import java.util.function.Function;

public class ItemDTOConverter implements GenericConverter<Item, ItemDTO> {
    @Override
    public ItemDTO apply(Item item) {
        return new ItemDTO();
    }

    @Override
    public <V> Function<V, ItemDTO> compose(Function<? super V, ? extends Item> before) {
        return GenericConverter.super.compose(before);
    }

    @Override
    public <V> Function<Item, V> andThen(Function<? super ItemDTO, ? extends V> after) {
        return GenericConverter.super.andThen(after);
    }

    @Override
    public ItemDTO convert(Item input) {
        return GenericConverter.super.convert(input);
    }

    @Override
    public List<ItemDTO> convert(List<Item> input) {
        return GenericConverter.super.convert(input);
    }
}
