package com.centralplatform.server.payload.request.Item;


import com.centralplatform.server.payload.request.Request;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = ItemInfoRequest.class, name = "info"),
    @JsonSubTypes.Type(value = ItemUpdateRequest.class, name = "update"),
    @JsonSubTypes.Type(value = ItemDeleteRequest.class, name = "delete"),
    @JsonSubTypes.Type(value = ItemCreateRequest.class, name = "create")
})
public abstract class ItemRequest extends Request {
}
