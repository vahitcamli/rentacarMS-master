package com.turkcell.TurkcellCRM.customerService.businnes.rules;

import com.turkcell.TurkcellCRM.customerService.businnes.messages.Messages;
import com.turkcell.TurkcellCRM.customerService.core.business.abstracts.MessageService;
import com.turkcell.TurkcellCRM.customerService.core.entities.utilities.exceptions.types.BusinessException;
import com.turkcell.TurkcellCRM.customerService.dataAccess.AddressRepository;
import com.turkcell.TurkcellCRM.customerService.entities.concretes.Address;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class AddressBusinnesRules {

    private final AddressRepository addressRepository;
    private final MessageService messageService;


    public void addressShouldBeExists(int addressId){
        Optional<Address> foundOptionalAddress = addressRepository.findById(addressId);
        if(foundOptionalAddress.isEmpty()){
            throw new BusinessException(messageService.getMessage(Messages.AddressErrors.addressNotFound));
        }
    }
}
