package com.centralplatform.server.controller.Institution;

import com.centralplatform.server.dto.Institution.InstitutionDTO;
import com.centralplatform.server.payload.request.Institution.InstitutionRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface InstitutionController<R extends InstitutionRequest> {
    // GET
    @RequestMapping(value = "/institution", method = RequestMethod.GET)
    ResponseEntity<? extends List<InstitutionDTO>> getInstitutions(@RequestBody R request);

    @RequestMapping(value = "/institution/{id}", method = RequestMethod.GET)
    ResponseEntity<? extends InstitutionDTO> getInstitutionById(@PathVariable("id") String id);

    // POST
    @RequestMapping(value = "/institution", method = RequestMethod.POST)
    ResponseEntity<? extends InstitutionDTO> uploadInstitution(@RequestBody R request);

    @RequestMapping(value = "/institution/update/{id}", method = RequestMethod.POST)
    ResponseEntity<? extends InstitutionDTO> updateInstitution(@RequestBody R request, @PathVariable("id") String id);

    @RequestMapping(value = "/institution/update", method = RequestMethod.POST)
    ResponseEntity<? extends List<InstitutionDTO>> uploadInstitutions(@RequestBody R request);


    // DELETE
    @RequestMapping(value = "/institution/delete/{id}", method = RequestMethod.GET)
    ResponseEntity<?> deleteInstitutionById(@PathVariable("id") String id);

    @RequestMapping(value = "/institution/delete", method = RequestMethod.GET)
    ResponseEntity<?> deleteInstitutions(@RequestBody R request);





}
