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
    <T extends ItemRequest> ResponseEntity<? extends List<ItemDTO>> getItems(@RequestBody T request);

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    ResponseEntity<? extends ItemDTO> getItemById(@PathVariable("id") String id);

    // POST
    @RequestMapping(value = "/item", method = RequestMethod.POST)
    <T extends ItemRequest> ResponseEntity<? extends ItemDTO> uploadItem(@RequestBody T request);

    @RequestMapping(value = "/item/update/{id}", method = RequestMethod.POST)
    <T extends ItemRequest> ResponseEntity<? extends ItemDTO> updateItem(@RequestBody T request, @PathVariable("id") String id);

    @RequestMapping(value = "/item/update", method = RequestMethod.POST)
    <T extends ItemRequest> ResponseEntity<? extends List<ItemDTO>> uploadItems(@RequestBody T request);


    // DELETE
    @RequestMapping(value = "/item/delete/{id}", method = RequestMethod.GET)
    ResponseEntity<?> deleteItemById(@PathVariable("id") String id);

    @RequestMapping(value = "/item/delete", method = RequestMethod.GET)
    <T extends ItemRequest> ResponseEntity<?> deleteItems(@RequestBody T request);
}
