package com.centralplatform.server.service.Institution;

import com.centralplatform.server.dto.Institution.InstitutionDTO;
import com.centralplatform.server.dto.Institution.InstitutionDTOConverter;
import com.centralplatform.server.model.Institution.Institution;
import com.centralplatform.server.payload.request.Institution.InstitutionRequest;
import com.centralplatform.server.repository.Institution.InstitutionRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InstitutionServiceImpl implements InstitutionService{

    private final InstitutionRepository institutionRepository;
    private final InstitutionDTOConverter converter;

    @Override
    public List<InstitutionDTO> getInstitutions(InstitutionRequest request) {

        return converter.convert(institutionRepository.findAll());
    }

    @Override
    public InstitutionDTO getInstitutionById(String id) {
        return converter.convert(institutionRepository.findById(UUID.fromString(id)).orElseThrow());
    }

    @Override
    public InstitutionDTO uploadInstitution(InstitutionRequest request) {
        Institution institution = Institution.builder().build();
        return converter.convert(institutionRepository.save(institution));
    }

    @Override
    public InstitutionDTO updateInstitution(InstitutionRequest request, String id) {
        return null;
    }

    @Override
    public List<InstitutionDTO> uploadInstitutions(InstitutionRequest request) {
        List<Institution> institutionList = new ArrayList<>();
        return converter.convert(institutionList);
    }

    @Override
    public void deleteInstitutionById(String id) {
        institutionRepository.delete(institutionRepository.findById(UUID.fromString(id)).orElseThrow());
    }

    @Override
    public void deleteInstitutions(InstitutionRequest request) {
        List<UUID> institutionIdList = new ArrayList<>();
        institutionRepository.deleteAll(institutionRepository.findAllById(institutionIdList));
    }
}
