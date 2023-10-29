package com.centralplatform.server.payload.request.UserAssignOrganizationRequest;

import com.centralplatform.server.payload.request.Request;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = UserAssignOrganizationRequestInfoRequest.class, name = "info"),
    @JsonSubTypes.Type(value = UserAssignOrganizationRequestDeleteRequest.class, name = "delete"),
    @JsonSubTypes.Type(value = UserAssignOrganizationRequestCreateRequest.class, name = "create")
})
public abstract class UserAssignOrganizationRequestRequest extends Request {
}
