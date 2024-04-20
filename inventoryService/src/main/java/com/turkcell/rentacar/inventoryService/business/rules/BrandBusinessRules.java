package com.turkcell.rentacar.inventoryService.business.rules;


import com.turkcell.rentacar.inventoryService.business.messages.Messages;
import com.turkcell.rentacar.inventoryService.core.business.abstracts.MessageService;
import com.turkcell.rentacar.inventoryService.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.turkcell.rentacar.inventoryService.dataAccess.BrandRepository;
import com.turkcell.rentacar.inventoryService.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    BrandRepository brandRepository;
    MessageService messageService;

    public void brandNameCanNotBeDuplicated(String brandName) {
        Optional<Brand> brand = brandRepository.findByNameIgnoreCase(brandName);
        if (brand.isPresent()) {
            throw new BusinessException(messageService.getMessage(Messages.BrandErrors.brandNameExists));
        }
    }

    public void brandShouldBeExist(int brandId) {
        Optional<Brand> foundOptionalBrand = brandRepository.findById(brandId);
        if (foundOptionalBrand.isEmpty()) {
            throw new BusinessException(messageService.getMessage(Messages.BrandErrors.brandNotFound));
        }
    }

}

