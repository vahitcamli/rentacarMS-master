package com.turkcell.TurkcellCRM.customerService.api.controllers;

import com.turkcell.TurkcellCRM.customerService.businnes.abstracts.ContactInfoService;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.request.create.CreateContactInfoRequest;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.request.update.UpdateContactInfoRequest;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.response.create.CreateContactInfoResponse;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.response.get.GetAllContactInfoResponse;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.response.get.GetContactInfoResponse;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.response.update.UpdateContactInfoResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("customerservice/api/v1/contactinfos")
public class ContactInfoController {
    private ContactInfoService contactInfoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateContactInfoResponse add(@Valid @RequestBody CreateContactInfoRequest createContactInfoRequest) {
        return contactInfoService.add(createContactInfoRequest);
    }

    @PutMapping("/{contactInfoId}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateContactInfoResponse update(@Valid @RequestBody UpdateContactInfoRequest updateContactInfoRequest, @PathVariable int contactInfoId) {
        return contactInfoService.update(updateContactInfoRequest,contactInfoId);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetContactInfoResponse getById(@PathVariable int id) {
        return contactInfoService.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllContactInfoResponse> getAll() {
        return contactInfoService.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id ){
        contactInfoService.delete(id);
    }
}
