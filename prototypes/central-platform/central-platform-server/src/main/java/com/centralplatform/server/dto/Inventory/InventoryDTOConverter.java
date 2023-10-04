package com.centralplatform.server.dto.Inventory;

import com.centralplatform.server.model.Inventory.Inventory;
import com.centralplatform.server.util.Converters.GenericConverter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class InventoryDTOConverter implements GenericConverter<Inventory, InventoryDTO> {
    @Override
    public InventoryDTO apply(Inventory location) {
        return new InventoryDTO();
    }

    @Override
    public <V> Function<V, InventoryDTO> compose(Function<? super V, ? extends Inventory> before) {
        return GenericConverter.super.compose(before);
    }

    @Override
    public <V> Function<Inventory, V> andThen(Function<? super InventoryDTO, ? extends V> after) {
        return GenericConverter.super.andThen(after);
    }

    @Override
    public InventoryDTO convert(Inventory input) {
        return GenericConverter.super.convert(input);
    }

    @Override
    public List<InventoryDTO> convert(List<Inventory> input) {
        return GenericConverter.super.convert(input);
    }
}
