package com.astontech.hr.services;

import com.astontech.hr.domain.Address;

import java.util.List;

public interface AddressService {
    List<Address> listAllAddresses ();
    Address getAddressById (Integer id);

    Address saveAddress(Address address);
    Iterable<Address> saveListOfAddresss(Iterable<Address> addressList);

    void deleteAddress(Integer id);
}
