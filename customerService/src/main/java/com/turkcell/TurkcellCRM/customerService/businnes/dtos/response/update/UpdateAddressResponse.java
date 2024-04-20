package com.turkcell.TurkcellCRM.customerService.businnes.dtos.response.update;


import com.turkcell.TurkcellCRM.customerService.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateAddressResponse {
    private String city;
    private String street;
    private String houseNumber;
    private String addressDescription;
}
