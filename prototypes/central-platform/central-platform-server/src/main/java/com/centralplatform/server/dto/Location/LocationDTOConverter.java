package com.centralplatform.server.dto.Location;

import com.centralplatform.server.model.Location.Location;
import com.centralplatform.server.util.Converters.GenericConverter;

import java.util.List;
import java.util.function.Function;

public class LocationDTOConverter implements GenericConverter<Location, LocationDTO> {
    @Override
    public LocationDTO apply(Location location) {
        return new LocationDTO();
    }

    @Override
    public <V> Function<V, LocationDTO> compose(Function<? super V, ? extends Location> before) {
        return GenericConverter.super.compose(before);
    }

    @Override
    public <V> Function<Location, V> andThen(Function<? super LocationDTO, ? extends V> after) {
        return GenericConverter.super.andThen(after);
    }

    @Override
    public LocationDTO convert(Location input) {
        return GenericConverter.super.convert(input);
    }

    @Override
    public List<LocationDTO> convert(List<Location> input) {
        return GenericConverter.super.convert(input);
    }
}
