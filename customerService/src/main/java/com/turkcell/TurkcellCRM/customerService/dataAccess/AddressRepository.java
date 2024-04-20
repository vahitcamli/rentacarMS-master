package com.turkcell.TurkcellCRM.customerService.dataAccess;

import com.turkcell.TurkcellCRM.customerService.entities.concretes.Address;
import com.turkcell.TurkcellCRM.customerService.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository  extends JpaRepository<Address,Integer> {

}
