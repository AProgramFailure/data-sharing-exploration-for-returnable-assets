package com.centralplatform.server.repository.OrganizationAccess;

import com.centralplatform.server.model.Organization.Organization;
import com.centralplatform.server.model.OrganizationAccess.OrganizationAccess;
import com.centralplatform.server.model.UserOrganizationApplication.StatusType;
import com.centralplatform.server.model.UserOrganizationApplication.UserOrganizationApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrganizationAccessRepository extends JpaRepository<OrganizationAccess, UUID> {
    List<OrganizationAccess> findOrganizationAccessesByOrganizationId(UUID organization_id);

    OrganizationAccess findOrganizationAccessByOrganizationId(UUID organization_id);

    @Query("SELECT oa FROM OrganizationAccess oa JOIN oa.allowedOrganizations ao WHERE ao.id = :organizationId")
    List<OrganizationAccess> findOrganizationAccessByAllowedOrganizationId(UUID organizationId);
}
