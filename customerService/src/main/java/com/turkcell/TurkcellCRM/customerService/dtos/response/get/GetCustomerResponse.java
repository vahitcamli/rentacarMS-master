package com.turkcell.TurkcellCRM.customerService.dtos.response.get;

import com.turkcell.TurkcellCRM.customerService.entities.enums.Gender;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCustomerResponse {
    private String firstName;
    private String secondName;
    private String lastName;
    private LocalDateTime birthDate;
    private Gender gender;
    private String fatherName;
    private String motherName;
    private String nationalNumber;

}
