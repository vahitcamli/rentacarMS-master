package com.turkcell.TurkcellCRM.customerService.businnes.concretes;

import com.turkcell.TurkcellCRM.customerService.businnes.abstracts.CustomerService;
import com.turkcell.TurkcellCRM.customerService.businnes.rules.CustomerBusinnesRules;
import com.turkcell.TurkcellCRM.customerService.core.entities.utilities.mapping.ModelMapperService;
import com.turkcell.TurkcellCRM.customerService.dataAccess.CustomerRepository;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.request.create.CreateCustomerRequest;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.request.update.UpdateCustomerRequest;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.response.create.CreateCustomerResponse;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.response.get.GetAllCustomerResponse;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.response.get.GetCustomerResponse;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.response.update.UpdateCustomerResponse;
import com.turkcell.TurkcellCRM.customerService.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
//todo bütün crud işlemlerini yap
    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;
    private CustomerBusinnesRules customerBusinnesRules;

    @Override
    public CreateCustomerResponse add(CreateCustomerRequest createCustomerRequest) {
         customerBusinnesRules.customerAlreadyExists(createCustomerRequest.getNationalityNumber());
         Customer customer= modelMapperService.forRequest().map(createCustomerRequest,Customer.class);
         customer.setCreatedDate(LocalDateTime.now());
         Customer createdCustomer = customerRepository.save(customer);
        return modelMapperService.forResponse().map(createdCustomer,CreateCustomerResponse.class);
    }

    @Override
    public void delete(int id) {
        customerBusinnesRules.customerShouldBeExists(id);
        customerRepository.deleteById(id);
    }

    @Override
    public GetCustomerResponse getById(int id) {
        customerBusinnesRules.customerShouldBeExists(id);
        Customer customer = customerRepository.findById(id).orElse(null);
        GetCustomerResponse getCustomerResponse = modelMapperService.forResponse().map(customer,GetCustomerResponse.class);
        return getCustomerResponse;
    }

    @Override
    public UpdateCustomerResponse update(UpdateCustomerRequest updateCustomerRequest, int customerId) {
        customerBusinnesRules.customerShouldBeExists(customerId);
        Customer customerToUpdate= modelMapperService.forRequest().map(updateCustomerRequest,Customer.class);
        customerToUpdate.setUpdatedDate(LocalDateTime.now());
        customerToUpdate.setId(customerId);
        Customer updatedCustomer= customerRepository.save(customerToUpdate);
        return modelMapperService.forResponse().map(updatedCustomer,UpdateCustomerResponse.class);
    }

    @Override
    public List<GetAllCustomerResponse> getAll() {
        List<Customer> customers = customerRepository.findAll();
       return customers.stream().map(customer ->
               modelMapperService.forResponse()
                       .map(customer, GetAllCustomerResponse.class)).toList();

    }
}
