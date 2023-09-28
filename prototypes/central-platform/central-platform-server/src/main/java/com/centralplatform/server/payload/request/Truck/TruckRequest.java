package com.centralplatform.server.payload.request.Truck;

import com.centralplatform.server.payload.request.Request;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = TruckInfoRequest.class, name = "info"),
    @JsonSubTypes.Type(value = TruckUpdateRequest.class, name = "update"),
    @JsonSubTypes.Type(value = TruckDeleteRequest.class, name = "delete"),
    @JsonSubTypes.Type(value = TruckCreateRequest.class, name = "create")
})
public abstract class TruckRequest extends Request {
}
