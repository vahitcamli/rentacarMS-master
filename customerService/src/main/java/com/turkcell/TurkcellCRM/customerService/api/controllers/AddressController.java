package com.turkcell.TurkcellCRM.customerService.api.controllers;

import com.turkcell.TurkcellCRM.customerService.businnes.abstracts.AddressService;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.request.create.CreateAddressRequest;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.request.update.UpdateAddressRequest;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.response.create.CreateAddressResponse;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.response.get.GetAddressResponse;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.response.get.GetAllAddressResponse;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.response.update.UpdateAddressResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("customerservice/api/v1/addresses")
public class AddressController {
    private AddressService addressService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateAddressResponse add(@Valid @RequestBody CreateAddressRequest createAddressRequest) {
        return addressService.add(createAddressRequest);
    }

    @PutMapping("/{addressId}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateAddressResponse update(@Valid @RequestBody UpdateAddressRequest updateAddressRequest, @PathVariable int addressId) {
        return addressService.update(updateAddressRequest,addressId);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetAddressResponse getById(@PathVariable int id) {
        return addressService.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllAddressResponse> getAll() {
        return addressService.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id ){
        addressService.delete(id);
    }
}
