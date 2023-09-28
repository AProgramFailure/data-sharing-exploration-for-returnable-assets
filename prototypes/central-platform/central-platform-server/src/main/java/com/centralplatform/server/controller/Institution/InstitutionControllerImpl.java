package com.centralplatform.server.controller.Institution;

import com.centralplatform.server.dto.Institution.InstitutionDTO;
import com.centralplatform.server.payload.request.Institution.InstitutionRequest;
import com.centralplatform.server.service.Institution.InstitutionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/prod")
@RequiredArgsConstructor
public class InstitutionControllerImpl implements InstitutionController<InstitutionRequest> {

    private final InstitutionServiceImpl institutionService;

    @Override
    public ResponseEntity<? extends InstitutionDTO> getInstitutionById(String id) {
        return ResponseEntity.ok(institutionService.getInstitutionById(id));
    }

    @Override
    public <T extends InstitutionRequest> ResponseEntity<? extends List<InstitutionDTO>> getInstitutions( T request) {
        return ResponseEntity.ok(institutionService.getInstitutions(request));
    }


    @Override
    public <T extends InstitutionRequest> ResponseEntity<? extends InstitutionDTO> uploadInstitution(T request) {
        return ResponseEntity.ok(institutionService.uploadInstitution(request));
    }

    @Override
    public <T extends InstitutionRequest> ResponseEntity<? extends InstitutionDTO> updateInstitution( T request, String id) {
        return null;
    }


    @Override
    public <T extends InstitutionRequest> ResponseEntity<? extends List<InstitutionDTO>> uploadInstitutions(T request) {
        return ResponseEntity.ok(institutionService.uploadInstitutions(request));
    }

    @Override
    public ResponseEntity<?> deleteInstitutionById(String id) {
        institutionService.deleteInstitutionById(id);
        return ResponseEntity.ok("Successfully deleted");
    }

    @Override
    public <T extends InstitutionRequest> ResponseEntity<?> deleteInstitutions(T request) {
        institutionService.deleteInstitutions(request);
        return ResponseEntity.ok("Successfully deleted");
    }
}
