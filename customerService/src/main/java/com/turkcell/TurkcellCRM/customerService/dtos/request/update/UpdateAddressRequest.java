package com.turkcell.TurkcellCRM.customerService.dtos.request.update;


import com.turkcell.TurkcellCRM.customerService.entities.concretes.Customer;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateAddressRequest {
    @NotNull
    private String city;

    @NotNull
    private String street;

    @NotNull
    private String houseNumber;

    @NotNull
    private String addressDescription;


}
