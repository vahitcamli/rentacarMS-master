package com.turkcell.TurkcellCRM.customerService.businnes.dtos.response.create;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateContactInfoResponse {
    private String email;
    private String homePhone;
    private String mobilePhone;
    private String tax;
}
