//package respositories;
//
//import com.astontech.hr.configuration.RepositoryConfiguration;
//import com.astontech.hr.domain.Address;
//import com.astontech.hr.repositories.AddressRepository;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import static org.junit.Assert.*;
//
///**
// * Created by Adrian.Flak on 8/15/2017.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
//public class AddressRepositoryTest {
//
//    private int id;
//
//    @Autowired
//    private AddressRepository addressRepository;
//
//    @Before
//    public void setUp(){
//        addressRepository.save((new Address("Home","1st S apt 1","1 city","MN","test11111")));
//        id = addressRepository.findAll().get(0).getId();
//    }
//
//    @After
//    public void tearDown(){
//        addressRepository.deleteAll();
//    }
//
//    @Test
//    public void test_FindOneById(){
//        assertEquals("test11111",addressRepository.findOne(id).getZipcode());
//    }
//
//    @Test
//    public void test_DeleteById(){
//        assertEquals(1, addressRepository.findAll().size());
//        addressRepository.delete(id);
//        assertEquals(0, addressRepository.findAll().size());
//    }
//
//}
