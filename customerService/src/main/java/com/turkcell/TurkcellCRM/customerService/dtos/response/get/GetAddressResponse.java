package com.turkcell.TurkcellCRM.customerService.dtos.response.get;


import com.turkcell.TurkcellCRM.customerService.entities.concretes.Customer;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAddressResponse {
    private String city;
    private String street;
    private String houseNumber;
    private String addressDescription;
}
