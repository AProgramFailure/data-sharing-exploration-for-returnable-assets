package com.centralplatform.server.controller.User.Admin;

import com.centralplatform.server.model.UserAssignOrganizationRequest.UserAssignOrganizationRequest;
import com.centralplatform.server.payload.request.UserAssignOrganizationRequest.UserAssignOrganizationRequestRequest;
import com.centralplatform.server.service.UserAssignOrganizationRequest.UserAssignOrganizationRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    private final UserAssignOrganizationRequestService userAssignOrganizationRequestService;

    public AdminController(UserAssignOrganizationRequestService userAssignOrganizationRequestService) {
        this.userAssignOrganizationRequestService = userAssignOrganizationRequestService;
    }

    @RequestMapping(value = "/user-assign-request", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('admin:read')")
    public <T extends UserAssignOrganizationRequestRequest> ResponseEntity<? extends List<UserAssignOrganizationRequest>> getRequests(@RequestBody T request) {
        return ResponseEntity.ok(userAssignOrganizationRequestService.getUserAssignOrganizationRequests(request));
    }
}
