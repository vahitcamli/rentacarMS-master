package com.turkcell.TurkcellCRM.customerService.businnes.concretes;

import com.turkcell.TurkcellCRM.customerService.businnes.abstracts.AddressService;
import com.turkcell.TurkcellCRM.customerService.businnes.rules.AddressBusinnesRules;
import com.turkcell.TurkcellCRM.customerService.core.entities.utilities.mapping.ModelMapperService;
import com.turkcell.TurkcellCRM.customerService.dataAccess.AddressRepository;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.request.create.CreateAddressRequest;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.request.update.UpdateAddressRequest;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.response.create.CreateAddressResponse;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.response.get.GetAddressResponse;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.response.get.GetAllAddressResponse;
import com.turkcell.TurkcellCRM.customerService.businnes.dtos.response.update.UpdateAddressResponse;
import com.turkcell.TurkcellCRM.customerService.entities.concretes.Address;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@AllArgsConstructor
public class AddressManager implements AddressService {
    private AddressRepository addressRepository;
    private ModelMapperService modelMapperService;
    private AddressBusinnesRules addressBusinnesRules;
    @Override
    public CreateAddressResponse add(CreateAddressRequest addressRequest) {
        Address address= modelMapperService.forRequest().map(addressRequest,Address.class);
        address.setCreatedDate(LocalDateTime.now());
        Address createdAddress = addressRepository.save(address);
        return modelMapperService.forResponse().map(createdAddress, CreateAddressResponse.class);
    }

    @Override
    public void delete(int id) {
        addressBusinnesRules.addressShouldBeExists(id);
        addressRepository.deleteById(id);
    }

    @Override
    public GetAddressResponse getById(int id) {
        Address address = addressRepository.findById(id).orElse(null);
        GetAddressResponse getAddressResponse = modelMapperService.forResponse().map(address,GetAddressResponse.class);
        return getAddressResponse;
    }

    @Override
    public UpdateAddressResponse update(UpdateAddressRequest updateAddressRequest, int addressId) {
        addressBusinnesRules.addressShouldBeExists(addressId);
        Address addressToUpdate= modelMapperService.forRequest().map(updateAddressRequest,Address.class);
        addressToUpdate.setUpdatedDate(LocalDateTime.now());
        addressToUpdate.setId(addressId);
        Address updatedAddress= addressRepository.save(addressToUpdate);
        return modelMapperService.forResponse().map(updatedAddress, UpdateAddressResponse.class);
    }

    @Override
    public List<GetAllAddressResponse> getAll() {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream().map(address ->
                modelMapperService.forResponse()
                        .map(address, GetAllAddressResponse.class)).toList();
    }
}
