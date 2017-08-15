package respositories.services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.Address;
import com.astontech.hr.repositories.AddressRepository;
import com.astontech.hr.services.AddressService;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Adrian.Flak on 8/15/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class AddressServiceTest {

    private int id;

    @Autowired
    private AddressService addressService;

    @Autowired
    private AddressRepository addressRepository;

    @Before
    public void setUP(){

        List<Address> addressList = new ArrayList<>();
        addressList.add(new Address("Home","1 st N","OneVille","MN","11111"));
        addressList.add(new Address("Office","2 st N","TwoVille","WI","22222"));

        List<Address> addressList1 = new ArrayList<>();
        addressList1.add(new Address("Office","3 st N","ThreeVille","MN","33333"));
        addressList1.add(new Address("Home","4 st N","FourVille","WI","44444"));

        addressService.saveListOfAddresss(addressList);
        addressService.saveListOfAddresss(addressList1);

        id = addressService.listAllAddresses().get(0).getId();

    }

    @After
    public void tearDown(){
        addressRepository.deleteAll();
    }

    @Test
    public void test_FindOneById(){
        assertEquals("1 st N",addressService.getAddressById(id).getStreetAddress());
    }

    @Test
    public void test_Update(){
        Address updateAddress = addressService.getAddressById(id);
        updateAddress.setStreetAddress("Updated Street");
        addressService.saveAddress(updateAddress);
        assertEquals("Updated Street", addressService.getAddressById(id).getStreetAddress());
    }

    @Test
    public void test_DeleteById(){
        assertEquals(4,addressService.listAllAddresses().size());
        addressService.deleteAddress(id);
        assertEquals(3,addressService.listAllAddresses().size());
    }
}
