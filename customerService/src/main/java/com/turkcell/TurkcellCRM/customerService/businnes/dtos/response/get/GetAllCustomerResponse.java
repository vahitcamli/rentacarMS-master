package com.turkcell.TurkcellCRM.customerService.businnes.dtos.response.get;

import com.turkcell.TurkcellCRM.customerService.entities.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllCustomerResponse {
    private String firstName;
    private String secondName;
    private String lastName;
    private LocalDateTime birthDate;
    private Gender gender;
    private String fatherName;
    private String motherName;
    private String nationalNumber;
    private int customerId;
}
