package com.turkcell.TurkcellCRM.customerService.api.controllers;

import com.turkcell.TurkcellCRM.customerService.businnes.abstracts.CustomerService;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.request.create.CreateCustomerRequest;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.request.update.UpdateCustomerRequest;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.response.create.CreateCustomerResponse;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.response.get.GetAllCustomerResponse;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.response.get.GetCustomerResponse;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.response.update.UpdateCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("customerservice/api/v1/customers")
public class CustomerController {
    private CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCustomerResponse add(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) {
        return customerService.add(createCustomerRequest);
    }

    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateCustomerResponse update(@Valid @RequestBody UpdateCustomerRequest updateCustomerRequest,@PathVariable int customerId) {
        return customerService.update(updateCustomerRequest,customerId);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetCustomerResponse getById(@PathVariable int id) {
        return customerService.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllCustomerResponse> getAll() {
        return customerService.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id ){
        customerService.delete(id);
    }
}
