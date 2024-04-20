package com.turkcell.rentacar.inventoryService.business.abstracts;

import com.turkcell.rentacar.inventoryService.business.dtos.requests.CreateBrandRequest;
import com.turkcell.rentacar.inventoryService.business.dtos.responses.CreateBrandResponse;
import com.turkcell.rentacar.inventoryService.business.dtos.responses.GetAllBrandResponse;
import org.springframework.stereotype.Service;

import java.util.List;



public interface BrandService {
    CreateBrandResponse add(CreateBrandRequest createBrandRequest);


    List<GetAllBrandResponse> getAll();

}
