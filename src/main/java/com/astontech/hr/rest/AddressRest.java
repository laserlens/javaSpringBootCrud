package com.astontech.hr.rest;

import com.astontech.hr.domain.Address;
import com.astontech.hr.services.AddressService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressRest {
    private Logger log = Logger.getLogger(AddressRest.class);

    private AddressService addressService;

    @Autowired
    public AddressRest(AddressService addressService){
        this.addressService = addressService;
    }

    //returns all address as a list
    @CrossOrigin
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Address> getAllAddresses(){
        return addressService.listAllAddresses();
    }

    //retuns address by id
    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Address getAddressById(@PathVariable int id){
        return addressService.getAddressById(id);
    }

    //saves an address
    @CrossOrigin
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Address saveAddress(@RequestBody Address address) {
        return addressService.saveAddress(address);
    }

    //delete address by id
    @CrossOrigin
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Boolean deleteAddress(@PathVariable int id){
        boolean results = false;
        try {
            addressService.deleteAddress(id);
            results = true;
        } catch (Exception ex){
            log.info(ex);

        }
        return results ;
    }
}
