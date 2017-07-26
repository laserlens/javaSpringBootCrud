package respositories.services;

import com.astontech.hr.application;
import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.services.VehicleService;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Adrian.Flak on 7/11/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {application.class})
@WebAppConfiguration
public class VehicleServiceTest {

    private Vehicle vehicle;
    private List<Vehicle> vehicleList;

    @Autowired
    private VehicleService vehicleService;

    @Before
    public void set_up (){
        vehicle = new Vehicle();
        vehicleList = new ArrayList<>();
        vehicle.setLicensePlate("555-ppp");
        vehicle.setVin("Find Me");
        vehicle.setYear(1900);


        vehicleService.saveVehicle(vehicle);

        vehicleList.add(new Vehicle("vin1","plate-1",1800));
        vehicleList.add(new Vehicle("vin2","plate-2",1900));
        vehicleList.add(new Vehicle("vin3","plate-3",2000));
        vehicleList.add(new Vehicle("vin4","plate-4",2010));


        vehicleService.saveVehicleList(vehicleList);


    }


    @Test
    public void testFindOneById(){
        Vehicle findMe = vehicleService.getVehicleById(vehicle.getId());

        assertEquals("Find Me",findMe.getVin());

    }

    @Test
    public void testFindAll(){

        Iterable<Vehicle> vehicleIterable = vehicleService.listAllVehicles();
        Long size = vehicleIterable.spliterator().getExactSizeIfKnown();

        assertEquals(5, size.intValue());

    }

    @Test
    public void  testUpdate(){

        Vehicle updateMe = vehicleService.getVehicleById(2);

        updateMe.setVin("Updated vin");
        vehicleService.saveVehicle(updateMe);

        Vehicle updated = vehicleService.getVehicleById(2);

        assertEquals("Updated vin", updated.getVin());

    }

    @Test
    public void testDelete(){

        Vehicle deletMe = vehicleService.getVehicleById(1);
        assertNotNull(deletMe.getId());

        vehicleService.deleteVehicleById(deletMe.getId());

        assertNull(vehicleService.getVehicleById(1));
    }

}
