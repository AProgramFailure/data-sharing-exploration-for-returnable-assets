package com.centralplatform.server.payload.request.Route;

import com.centralplatform.server.model.Route.Route;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RouteUpdateRequest extends RouteRequest {

    Route route;
}
