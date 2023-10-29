package com.centralplatform.server.service.UserOrganizationApplication;

import com.centralplatform.server.model.UserOrganizationApplication.UserOrganizationApplication;
import com.centralplatform.server.payload.request.UserOrganizationApplication.UserOrganizationApplicationRequest;
import com.centralplatform.server.repository.UserOrganizationApplicationRepository.UserOrganizationApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserOrganizationApplicationService {

    private final UserOrganizationApplicationRepository organizationApplicationRepository;

    public List<UserOrganizationApplication> getUserOrganizationApplications(UserOrganizationApplicationRequest request) {
        return organizationApplicationRepository.findAll();
    }

//    public UserAssignOrganizationRequest uploadUserAssignOrganizationRequest(UserAssignOrganizationRequestRequest request) {
//        UserAssignOrganizationRequest userAssignOrganizationRequest = UserAssignOrganizationRequest.builder().build();
//        return organizationRequestRepository.save(userAssignOrganizationRequest);
//    }
//
//    public void deleteUserAssignOrganizationRequestById(String id) {
//        organizationRequestRepository.delete(organizationRequestRepository.findById(UUID.fromString(id)).orElseThrow());
//    }
}

