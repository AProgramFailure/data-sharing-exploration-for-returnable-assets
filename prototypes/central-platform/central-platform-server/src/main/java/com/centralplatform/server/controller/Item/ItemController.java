package com.centralplatform.server.controller.Item;


import com.centralplatform.server.dto.Item.ItemDTO;
import com.centralplatform.server.payload.request.Item.ItemInfoRequest;
import com.centralplatform.server.payload.request.Item.ItemRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface ItemController<R extends ItemRequest> {

    // GET
    @RequestMapping(value = "/item", method = RequestMethod.GET)
    ResponseEntity<? extends List<ItemDTO>> getInstitutions(@RequestBody ItemInfoRequest request);

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    ResponseEntity<? extends ItemDTO> getInstitutionById(@PathVariable("id") String id);

    // POST
    @RequestMapping(value = "/item", method = RequestMethod.POST)
    ResponseEntity<? extends ItemDTO> uploadInstitution(@RequestBody R request);

    @RequestMapping(value = "/item/update/{id}", method = RequestMethod.POST)
    ResponseEntity<? extends ItemDTO> updateInstitution(@RequestBody R request, @PathVariable("id") String id);

    @RequestMapping(value = "/item/update", method = RequestMethod.POST)
    ResponseEntity<? extends List<ItemDTO>> uploadInstitutions(@RequestBody R request);


    // DELETE
    @RequestMapping(value = "/item/delete/{id}", method = RequestMethod.GET)
    ResponseEntity<?> deleteInstitutionById(@PathVariable("id") String id);

    @RequestMapping(value = "/item/delete", method = RequestMethod.GET)
    ResponseEntity<?> deleteInstitutions(@RequestBody R request);
}
