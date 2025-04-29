package com.employee.management.dto.mapper;

import com.employee.management.dto.AddressDTO;
import com.employee.management.entity.Address;

import java.util.ArrayList;
import java.util.List;

public class AddressMapper {
    public static List<AddressDTO> toDtoList(List<Address> addresses) {
        if (addresses == null) {
            return null;
        }
        List<AddressDTO> dtos = new ArrayList<>();
        for (Address address : addresses) {
            dtos.add(toDTO(address));
        }
        return dtos;
    }
    public static AddressDTO toDTO(Address address) {
        if (address == null) {
            return null;
        }
        AddressDTO dto = new AddressDTO();
        dto.setType(address.getType());
        dto.setStreet(address.getStreet());
        dto.setCity(address.getCity());
        dto.setState(address.getState());
        dto.setZipCode(address.getZipCode());
        return dto;
    }
    public static List<Address> toEntityList(List<AddressDTO> dtos) {
        if (dtos == null) {
            return null;
        }
        List<Address> addresses = new ArrayList<>();
        for (AddressDTO dto : dtos) {
            addresses.add(toEntity(dto));
        }
        return addresses;
    }

    public static Address toEntity(AddressDTO dto) {
        if (dto == null) {
            return null;
        }
        Address address = new Address();
        address.setType(dto.getType());
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setZipCode(dto.getZipCode());
        return address;
    }
}
