package com.turkcell.TurkcellCRM.customerService.dtos.response.create;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCustomerResponse {

    private String firstName;
    private String lastName;
    private String nationalNumber;
}
