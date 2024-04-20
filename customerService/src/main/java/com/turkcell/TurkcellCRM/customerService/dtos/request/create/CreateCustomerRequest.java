package com.turkcell.TurkcellCRM.customerService.dtos.request.create;

import com.turkcell.TurkcellCRM.customerService.entities.enums.Gender;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCustomerRequest {
    @NotNull
    private String firstName;

    private String secondName;

    @NotNull
    private String lastName;

    @NotNull
    private LocalDateTime birthDate;

    @NotNull
    private Gender gender;

    private String fatherName;

    private String motherName;

    @NotNull
    @Size(min=11,max = 11)
    private String nationalityNumber;

}
