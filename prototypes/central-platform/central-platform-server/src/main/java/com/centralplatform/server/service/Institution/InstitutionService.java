package com.centralplatform.server.service.Institution;

import com.centralplatform.server.dto.Institution.InstitutionDTO;
import com.centralplatform.server.payload.request.Institution.InstitutionRequest;

import java.util.List;

public interface InstitutionService<R extends InstitutionRequest> {

    List<InstitutionDTO> getInstitutions(R request);

    InstitutionDTO getInstitutionById(String id);

    InstitutionDTO uploadInstitution(R request);

    InstitutionDTO updateInstitution(R request, String id);

    List<InstitutionDTO> uploadInstitutions(R request);

    void deleteInstitutionById(String id);

    void deleteInstitutions(R request);

}
