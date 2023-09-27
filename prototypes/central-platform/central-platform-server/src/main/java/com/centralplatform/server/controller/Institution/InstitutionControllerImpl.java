package com.centralplatform.server.controller.Institution;

import com.centralplatform.server.dto.Institution.InstitutionDTO;
import com.centralplatform.server.payload.request.Institution.InstitutionInfoRequest;
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
    public ResponseEntity<? extends List<InstitutionDTO>> getInstitutions(InstitutionInfoRequest request) {
        return ResponseEntity.ok(institutionService.getInstitutions(request));
    }

    @Override
    public ResponseEntity<? extends InstitutionDTO> getInstitutionById(String id) {
        return ResponseEntity.ok(institutionService.getInstitutionById(id));
    }

    @Override
    public ResponseEntity<? extends InstitutionDTO> uploadInstitution(InstitutionRequest request) {
        return ResponseEntity.ok(institutionService.uploadInstitution(request));
    }

    @Override
    public ResponseEntity<? extends InstitutionDTO> updateInstitution(InstitutionRequest request, String id) {
        return ResponseEntity.ok(institutionService.updateInstitution(request,id));
    }

    @Override
    public ResponseEntity<? extends List<InstitutionDTO>> uploadInstitutions(InstitutionRequest request) {
        return ResponseEntity.ok(institutionService.uploadInstitutions(request));
    }

    @Override
    public ResponseEntity<?> deleteInstitutionById(String id) {
        institutionService.deleteInstitutionById(id);
        return ResponseEntity.ok("Successfully deleted");
    }

    @Override
    public ResponseEntity<?> deleteInstitutions(InstitutionRequest request) {
        institutionService.deleteInstitutions(request);
        return ResponseEntity.ok("Successfully deleted");
    }
}
