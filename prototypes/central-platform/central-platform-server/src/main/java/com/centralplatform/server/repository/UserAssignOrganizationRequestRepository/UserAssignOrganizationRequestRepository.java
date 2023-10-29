package com.centralplatform.server.repository.UserAssignOrganizationRequestRepository;

import com.centralplatform.server.model.UserAssignOrganizationRequest.UserAssignOrganizationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserAssignOrganizationRequestRepository extends JpaRepository<UserAssignOrganizationRequest, UUID> {

}
