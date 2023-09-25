package com.centralplatform.server.dto.Route;

import com.centralplatform.server.model.Route.Route;
import com.centralplatform.server.util.Converters.GenericConverter;

import java.util.List;
import java.util.function.Function;

public class RouteDTOConverter implements GenericConverter<Route, RouteDTO> {
    @Override
    public RouteDTO apply(Route route) {
        return new RouteDTO();
    }

    @Override
    public <V> Function<V, RouteDTO> compose(Function<? super V, ? extends Route> before) {
        return GenericConverter.super.compose(before);
    }

    @Override
    public <V> Function<Route, V> andThen(Function<? super RouteDTO, ? extends V> after) {
        return GenericConverter.super.andThen(after);
    }

    @Override
    public RouteDTO convert(Route input) {
        return GenericConverter.super.convert(input);
    }

    @Override
    public List<RouteDTO> convert(List<Route> input) {
        return GenericConverter.super.convert(input);
    }
}
