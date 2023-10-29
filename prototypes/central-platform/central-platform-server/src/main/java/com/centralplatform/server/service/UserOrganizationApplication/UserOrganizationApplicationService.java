package com.centralplatform.server.service.UserOrganizationApplication;

import com.centralplatform.server.model.User.User;
import com.centralplatform.server.model.UserOrganizationApplication.UserOrganizationApplication;
import com.centralplatform.server.payload.request.UserOrganizationApplication.UserOrganizationApplicationRequest;
import com.centralplatform.server.repository.User.UserRepository;
import com.centralplatform.server.repository.UserOrganizationApplicationRepository.UserOrganizationApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserOrganizationApplicationService {

    private final UserOrganizationApplicationRepository organizationApplicationRepository;
    private final UserRepository userRepository;

    public List<UserOrganizationApplication> getUserOrganizationApplications() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<UserOrganizationApplication> resultList = new ArrayList<>();

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            String userEmail = ((UserDetails) authentication.getPrincipal()).getUsername();
            Optional<User> user = ((userRepository.findByEmail(userEmail)));

            if(user.isPresent()){
                resultList = organizationApplicationRepository.findByOrganizationId(user.get().getOrganizationId());
            }
        }

        return resultList;
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

