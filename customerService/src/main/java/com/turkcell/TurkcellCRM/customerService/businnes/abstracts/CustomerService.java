package com.turkcell.TurkcellCRM.customerService.businnes.abstracts;

import com.turkcell.TurkcellCRM.customerService.businnes.dtos.request.create.CreateCustomerRequest;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.request.update.UpdateCustomerRequest;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.response.create.CreateCustomerResponse;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.response.get.GetAllCustomerResponse;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.response.get.GetCustomerResponse;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.response.update.UpdateCustomerResponse;

import java.util.List;

public interface CustomerService {
    //todo response ve request yaz
    CreateCustomerResponse add(CreateCustomerRequest customer);
    void delete(int id);
    GetCustomerResponse getById(int id);
    UpdateCustomerResponse update(UpdateCustomerRequest updateCustomerRequest, int customerId);
    List<GetAllCustomerResponse> getAll();
}
