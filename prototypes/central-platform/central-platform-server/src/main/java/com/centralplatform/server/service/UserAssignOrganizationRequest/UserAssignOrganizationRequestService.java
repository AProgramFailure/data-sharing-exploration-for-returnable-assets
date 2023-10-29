package com.centralplatform.server.service.UserAssignOrganizationRequest;

import com.centralplatform.server.model.UserAssignOrganizationRequest.UserAssignOrganizationRequest;
import com.centralplatform.server.payload.request.UserAssignOrganizationRequest.UserAssignOrganizationRequestRequest;
import com.centralplatform.server.repository.UserAssignOrganizationRequestRepository.UserAssignOrganizationRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAssignOrganizationRequestService {

    private final UserAssignOrganizationRequestRepository organizationRequestRepository;

    public List<UserAssignOrganizationRequest> getUserAssignOrganizationRequests(UserAssignOrganizationRequestRequest request) {
        return organizationRequestRepository.findAll();
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

