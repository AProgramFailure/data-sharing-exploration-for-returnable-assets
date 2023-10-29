package com.centralplatform.server.controller.User.Admin;

import com.centralplatform.server.model.UserOrganizationApplication.UserOrganizationApplication;
import com.centralplatform.server.payload.request.UserOrganizationApplication.UserOrganizationApplicationRequest;
import com.centralplatform.server.service.UserOrganizationApplication.UserOrganizationApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    private final UserOrganizationApplicationService userOrganizationApplicationService;

    public AdminController(UserOrganizationApplicationService userOrganizationApplicationService) {
        this.userOrganizationApplicationService = userOrganizationApplicationService;
    }

    @RequestMapping(value = "/user-assign-request", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('admin:read')")
    public <T extends UserOrganizationApplicationRequest> ResponseEntity<? extends List<UserOrganizationApplication>> getUserOrganizationApplications(@RequestBody T request) {
        return ResponseEntity.ok(userOrganizationApplicationService.getUserOrganizationApplications(request));
    }
}
