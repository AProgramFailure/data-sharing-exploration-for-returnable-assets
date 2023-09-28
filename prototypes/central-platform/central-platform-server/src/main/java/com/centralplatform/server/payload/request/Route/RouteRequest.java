package com.centralplatform.server.payload.request.Route;

import com.centralplatform.server.payload.request.Request;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = RouteInfoRequest.class, name = "info"),
    @JsonSubTypes.Type(value = RouteUpdateRequest.class, name = "update"),
    @JsonSubTypes.Type(value = RouteDeleteRequest.class, name = "delete"),
    @JsonSubTypes.Type(value = RouteCreateRequest.class, name = "create")
})
public abstract class RouteRequest extends Request {
}
