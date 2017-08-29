//package respositories.services;
//
//import com.astontech.hr.Application;
//import com.astontech.hr.domain.Vehicle;
//import com.astontech.hr.domain.VehicleMake;
//import com.astontech.hr.domain.VehicleModel;
//
//import com.astontech.hr.repositories.VehicleMakeRepository;
//import com.astontech.hr.services.VehicleMakeService;
//import com.astontech.hr.services.VehicleService;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
///**
// * Created by Adrian.Flak on 7/11/2017.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = {Application.class})
//@WebAppConfiguration
//public class VehicleMakeServiceTest {
//
//    private List<Vehicle> vehicleList;
//    private List<Vehicle> vehicleList2;
//
//
//    private List<VehicleModel> vehicleModelList;
//    private List<VehicleModel> vehicleModelList2;
//
//    private List<VehicleMake> vehicleMakeList;
//
//    private VehicleMake vehicleMake;
//
//    @Autowired
//    private VehicleMakeService vehicleMakeService;
//
//    @Autowired
//    private VehicleMakeRepository vehicleMakeRepository;
//
//    @Autowired
//    private VehicleService vehicleService;
//
//    @Before
//    public void setUp() {
//        vehicleMake = new VehicleMake();
//        vehicleList = new ArrayList<>();
//        vehicleList2 = new ArrayList<>();
//        vehicleModelList = new ArrayList<>();
//        vehicleModelList2 = new ArrayList<>();
//        vehicleMakeList = new ArrayList<>();
//
//        vehicleList.add(new Vehicle("vin1","plate-1",1800));
//        vehicleList.add(new Vehicle("vin2","plate-2",1900));
//        vehicleList.add(new Vehicle("vin3","plate-3",2000));
//        vehicleList.add(new Vehicle("vin4","plate-4",2010));
//
//        vehicleList2.add(new Vehicle("2vin1","2plate-1",1800));
//        vehicleList2.add(new Vehicle("2vin2","2plate-2",1900));
//        vehicleList2.add(new Vehicle("2vin3","2plate-3",2000));
//        vehicleList2.add(new Vehicle("2vin4","2plate-4",2010));
//
//        vehicleModelList.add(new VehicleModel("Model one", vehicleList));
//        vehicleModelList2.add(new VehicleModel("Model two", vehicleList2));
//
//        vehicleMakeList.add(new VehicleMake("Make one", vehicleModelList));
//        vehicleMakeList.add(new VehicleMake("Make two", vehicleModelList2));
//
//        vehicleMakeService.saveVehicleMakeList(vehicleMakeList);
//    }
//
//    @After
//    public void tearDown(){
//        vehicleMakeRepository.deleteAll();
//    }
//
//    @Test
//     public void testSaveOne(){
//
//        vehicleMake.setVehicleMakeName("test one name");
//        assertNull(vehicleMake.getId());
//        vehicleMakeService.saveVehicleMake(vehicleMake);
//        assertNotNull(vehicleMake.getId());
//
//    }
//
//    @Test
//    public void testSaveEveryThing(){
//
//        assertNotNull(vehicleMakeList.get(0).getId());
//
//    }
//
//
//    @Test
//    public void testFindMakeModelAndVehicles(){
//        Iterable<VehicleMake> makeList = vehicleMakeService.listAllVehicleMakes();
//
//        assertEquals("Make one",makeList.iterator().next().getVehicleMakeName());
//
//        assertEquals("Model one",makeList.iterator().next().getModelList().get(0).getVehicleModelName());
//
//        assertEquals("vin1",makeList.iterator().next().getModelList().get(0).getVehicleList().get(0).getVin());
//
//
//    }
//
//    @Test
//    public void testDeleteWorksForMAkeModelAndVehicle(){
//        Iterable<VehicleMake> deleteMe = vehicleMakeService.listAllVehicleMakes();
//
//        assertEquals("vin1", deleteMe.iterator().next().getModelList().get(0).getVehicleList().get(0).getVin());
//
//        vehicleMakeService.deleteVehicleMakeById(deleteMe.iterator().next().getId());
//
//        Iterable<Vehicle> vehicleIterable = vehicleService.listAllVehicles();
//        Iterable<VehicleMake> afterDelete = vehicleMakeService.listAllVehicleMakes();
//
//        assertNotEquals("vin1", afterDelete.iterator().next().getModelList().get(0).getVehicleList().get(0).getVin());
//
//        assertNotEquals("vin1", vehicleIterable.iterator().next().getVin());
//
//        for (Vehicle testForVin1: vehicleIterable){
//            assertNotEquals("vin1", testForVin1.getVin());
//        }
//
//
//    }
//
//
//
//
//}
