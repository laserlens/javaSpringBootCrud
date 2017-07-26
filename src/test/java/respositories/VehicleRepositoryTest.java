package respositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.repositories.VehicleRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Adrian.Flak on 7/11/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class VehicleRepositoryTest {

    private Vehicle vehicle;
    private List<Vehicle> vehicleList;

    @Autowired
    private VehicleRepository   vehicleRepository;

    @Before
    public void set_up (){
        vehicle = new Vehicle();
        vehicleList = new ArrayList<>();
        vehicle.setLicensePlate("555-ppp");
        vehicle.setVin("Find Me");
        vehicle.setYear(1900);


        vehicleRepository.save(vehicle);

        vehicleList.add(new Vehicle("vin1","plate-1",1800));
        vehicleList.add(new Vehicle("vin2","plate-2",1900));
        vehicleList.add(new Vehicle("vin3","plate-3",2000));
        vehicleList.add(new Vehicle("vin4","plate-4",2010));


        vehicleRepository.save(vehicleList);


    }

    @After
    public void tear_down (){
        vehicleRepository.deleteAll();
    }

    @Test
    public void testFindOneById(){
        Vehicle findMe = vehicleRepository.findOne(vehicle.getId());

        assertEquals("Find Me",findMe.getVin());

    }

    @Test
    public void testFindAll(){

        Iterable<Vehicle> vehicleIterable = vehicleRepository.findAll();
        Long size = vehicleIterable.spliterator().getExactSizeIfKnown();

        assertEquals(5, size.intValue());

    }

    @Test
    public void  testUpdate(){

        Vehicle updateMe = vehicleRepository.findOne(1);

        updateMe.setVin("Updated vin");
        vehicleRepository.save(updateMe);

        Vehicle updated = vehicleRepository.findOne(1);

        assertEquals("Updated vin", updated.getVin());

    }

}
