package com.centralplatform.server.payload.request.Institution;

import com.centralplatform.server.payload.request.Request;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = InstitutionInfoRequest.class, name = "info"),
    @JsonSubTypes.Type(value = InstitutionUpdateRequest.class, name = "update"),
    @JsonSubTypes.Type(value = InstitutionDeleteRequest.class, name = "delete"),
    @JsonSubTypes.Type(value = InstitutionCreateRequest.class, name = "create")
})
public abstract class InstitutionRequest extends Request {
}
