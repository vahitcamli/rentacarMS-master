package com.turkcell.TurkcellCRM.customerService.businnes.rules;

import com.turkcell.TurkcellCRM.customerService.businnes.messages.Messages;
import com.turkcell.TurkcellCRM.customerService.core.business.abstracts.MessageService;
import com.turkcell.TurkcellCRM.customerService.core.entities.utilities.exceptions.types.BusinessException;
import com.turkcell.TurkcellCRM.customerService.dataAccess.CustomerRepository;
import com.turkcell.TurkcellCRM.customerService.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerBusinnesRules {
    private final CustomerRepository customerRepository;
    private final MessageService messageService;

    public void customerShouldBeExists(int customerId){
        Optional<Customer> foundOptionalCustomer = customerRepository.findById(customerId);
        if(foundOptionalCustomer.isEmpty()){
            throw new BusinessException(messageService.getMessage(Messages.CustomerErrors.customerNotFound));
        }
    }
    public void customerAlreadyExists(String nationalityNumber){
        Optional<Customer> foundOptionalCustomer = customerRepository.findByNationalityNumber(nationalityNumber);
        if(!foundOptionalCustomer.isEmpty()){
            throw new BusinessException(messageService.getMessage(Messages.CustomerErrors.customerExists));
        }

    }


}
