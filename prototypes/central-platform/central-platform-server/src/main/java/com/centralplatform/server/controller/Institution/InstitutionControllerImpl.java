package com.centralplatform.server.controller.Institution;

import com.centralplatform.server.dto.Institution.InstitutionDTO;
import com.centralplatform.server.payload.request.Institution.InstitutionRequest;
import com.centralplatform.server.service.Institution.InstitutionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InstitutionControllerImpl implements InstitutionController<InstitutionRequest> {

    private final InstitutionServiceImpl institutionService;
    @Override
    public ResponseEntity<? extends List<InstitutionDTO>> getInstitutions(InstitutionRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<? extends InstitutionDTO> getInstitutionById(String id) {
        return null;
    }

    @Override
    public ResponseEntity<? extends InstitutionDTO> uploadInstitution(InstitutionRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<? extends InstitutionDTO> updateInstitution(InstitutionRequest request, String id) {
        return null;
    }

    @Override
    public ResponseEntity<? extends List<InstitutionDTO>> uploadInstitutions(InstitutionRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteInstitutionById(String id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteInstitutions(InstitutionRequest request) {
        return null;
    }
}
