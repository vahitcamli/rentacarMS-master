package com.turkcell.rentacar.inventoryService.api.controllers;


import com.turkcell.rentacar.inventoryService.business.abstracts.BrandService;
import com.turkcell.rentacar.inventoryService.business.dtos.requests.CreateBrandRequest;
import com.turkcell.rentacar.inventoryService.business.dtos.responses.CreateBrandResponse;
import com.turkcell.rentacar.inventoryService.business.dtos.responses.GetAllBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("inventoryservice/api/v1/brands")
public class BrandsController {
    private BrandService brandService; //101

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateBrandResponse add(@Valid @RequestBody CreateBrandRequest createBrandRequest) {
        return brandService.add(createBrandRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllBrandResponse> getAll() {
        return brandService.getAll();
    }

}
