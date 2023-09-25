package com.centralplatform.server.dto.Truck;

import com.centralplatform.server.model.Truck.Truck;
import com.centralplatform.server.util.Converters.GenericConverter;

import java.util.List;
import java.util.function.Function;

public class TruckDTOConverter implements GenericConverter<Truck, TruckDTO> {
    @Override
    public TruckDTO apply(Truck truck) {
        return new TruckDTO();
    }

    @Override
    public <V> Function<V, TruckDTO> compose(Function<? super V, ? extends Truck> before) {
        return GenericConverter.super.compose(before);
    }

    @Override
    public <V> Function<Truck, V> andThen(Function<? super TruckDTO, ? extends V> after) {
        return GenericConverter.super.andThen(after);
    }

    @Override
    public TruckDTO convert(Truck input) {
        return GenericConverter.super.convert(input);
    }

    @Override
    public List<TruckDTO> convert(List<Truck> input) {
        return GenericConverter.super.convert(input);
    }
}
