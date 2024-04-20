package com.turkcell.TurkcellCRM.customerService.businnes.rules;

import com.turkcell.TurkcellCRM.customerService.businnes.messages.Messages;
import com.turkcell.TurkcellCRM.customerService.core.business.abstracts.MessageService;
import com.turkcell.TurkcellCRM.customerService.core.entities.utilities.exceptions.types.BusinessException;
import com.turkcell.TurkcellCRM.customerService.dataAccess.ContactInfoRepository;
import com.turkcell.TurkcellCRM.customerService.entities.concretes.ContactInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class ContactInfoBusinnesRules {

    private final ContactInfoRepository contactInfoRepository;
    private final MessageService messageService;

    public void contactInfoShouldBeExists(int addressId){
        Optional<ContactInfo> foundOptionalContactInfo= contactInfoRepository.findById(addressId);
        if(foundOptionalContactInfo.isEmpty()){
            throw new BusinessException(messageService.getMessage(Messages.ContactInfoErrors.contactInfoNotFound));
        }
    }
}
