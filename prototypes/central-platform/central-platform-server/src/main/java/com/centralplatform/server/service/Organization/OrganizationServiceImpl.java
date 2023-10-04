package com.centralplatform.server.service.Organization;

import com.centralplatform.server.dto.Organization.OrganizationDTO;
import com.centralplatform.server.dto.Organization.OrganizationDTOConverter;
import com.centralplatform.server.model.Organization.Organization;
import com.centralplatform.server.payload.request.Organization.OrganizationRequest;
import com.centralplatform.server.repository.Organization.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final OrganizationDTOConverter converter;

    @Override
    public List<OrganizationDTO> getOrganizations(OrganizationRequest request) {

        return converter.convert(organizationRepository.findAll());
    }

    @Override
    public OrganizationDTO getOrganizationById(String id) {
        return converter.convert(organizationRepository.findById(UUID.fromString(id)).orElseThrow());
    }

    @Override
    public OrganizationDTO uploadOrganization(OrganizationRequest request) {
        Organization organization = Organization.builder().build();
        return converter.convert(organizationRepository.save(organization));
    }

    @Override
    public OrganizationDTO updateOrganization(OrganizationRequest request, String id) {
        return null;
    }

    @Override
    public List<OrganizationDTO> uploadOrganizations(OrganizationRequest request) {
        List<Organization> organizationList = new ArrayList<>();
        return converter.convert(organizationList);
    }

    @Override
    public void deleteOrganizationById(String id) {
        organizationRepository.delete(organizationRepository.findById(UUID.fromString(id)).orElseThrow());
    }

    @Override
    public void deleteOrganizations(OrganizationRequest request) {
        List<UUID> organizationIdList = new ArrayList<>();
        organizationRepository.deleteAll(organizationRepository.findAllById(organizationIdList));
    }
}
