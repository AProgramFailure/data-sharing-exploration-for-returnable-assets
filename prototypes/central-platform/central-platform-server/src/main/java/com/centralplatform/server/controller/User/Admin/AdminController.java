package com.centralplatform.server.controller.User.Admin;

import com.centralplatform.server.dto.UserOrganizationApplication.UserOrganizationApplicationDTO;
import com.centralplatform.server.model.UserOrganizationApplication.UserOrganizationApplication;
import com.centralplatform.server.payload.request.UserOrganizationApplication.UserOrganizationApplicationCreateRequest;
import com.centralplatform.server.payload.request.UserOrganizationApplication.UserOrganizationApplicationRequest;
import com.centralplatform.server.payload.request.UserOrganizationApplication.UserOrganizationApplicationUpdateRequest;
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
    public ResponseEntity<? extends List<UserOrganizationApplicationDTO>> getUserOrganizationApplications() {
        return ResponseEntity.ok(userOrganizationApplicationService.getUserOrganizationApplications());
    }

    @RequestMapping(value = "/user-assign-request/update/{id}", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<UserOrganizationApplication> updateUserOrganizationApplication(@RequestBody UserOrganizationApplicationUpdateRequest request, @PathVariable("id") String id) {
        return ResponseEntity.ok(userOrganizationApplicationService.updateUserOrganizationApplication(request, id));
    }
}
