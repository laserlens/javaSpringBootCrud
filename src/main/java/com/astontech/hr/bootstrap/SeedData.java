package com.astontech.hr.bootstrap;

import com.astontech.hr.domain.*;
import com.astontech.hr.services.ElementService;
import com.astontech.hr.services.ElementTypeService;
import com.astontech.hr.services.impl.ElementServiceImpl;
import com.astontech.hr.services.impl.ElementTypeServiceImpl;
import com.astontech.hr.services.impl.VehicleMakeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian.Flak on 6/30/2017.
 */
@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ElementTypeServiceImpl elementTypeService;

    @Autowired
    private VehicleMakeServiceImpl vehicleMakeService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        generateElementsAndElementTypes();
        getnerateMakeModelAndVehicles();

    }

    private void generateElementsAndElementTypes(){

        ElementType lapTopType = new ElementType("Laptop");

        List<Element> elementListLabtop = new ArrayList<>();
        elementListLabtop.add(new Element("Acer"));
        elementListLabtop.add(new Element("Dell"));
        elementListLabtop.add(new Element("Apple"));
        elementListLabtop.add(new Element("Windows"));

        lapTopType.setElementList(elementListLabtop);

        elementTypeService.saveElementType(lapTopType);

        ElementType phone = new ElementType("Phone");

        List<Element> elementListPhone = new ArrayList<>();
        elementListPhone.add(new Element("Cell"));
        elementListPhone.add(new Element("Work"));
        elementListPhone.add(new Element("Home"));
        elementListPhone.add(new Element("Other"));

        phone.setElementList(elementListPhone);

        elementTypeService.saveElementType(phone);

        ElementType taxSoftWare = new ElementType("Tax Software");

        List<Element> elementListTaxSoftWare = new ArrayList<>();
        elementListTaxSoftWare.add(new Element("Quickens"));
        elementListTaxSoftWare.add(new Element("Tax Slayer"));
        elementListTaxSoftWare.add(new Element("Tax Man"));
        elementListTaxSoftWare.add(new Element("Tax Tax"));

        taxSoftWare.setElementList(elementListTaxSoftWare);

        elementTypeService.saveElementType(taxSoftWare);

    }

    private void getnerateMakeModelAndVehicles(){


        List<Vehicle> vehicleList = new ArrayList<>();
        List<Vehicle> vehicleList2 = new ArrayList<>();
        List<Vehicle> vehicleList3 = new ArrayList<>();
        List<Vehicle> vehicleList4 = new ArrayList<>();

        List<VehicleModel> vehicleModelList = new ArrayList<>();
        List<VehicleModel> vehicleModelList2 = new ArrayList<>();


        List<VehicleMake> vehicleMakeList = new ArrayList<>();

        vehicleList.add(new Vehicle("vin1","plate-1",1800));
        vehicleList.add(new Vehicle("vin2","plate-2",1900));
        vehicleList.add(new Vehicle("vin3","plate-3",2000));
        vehicleList.add(new Vehicle("vin4","plate-4",2010));

        vehicleList2.add(new Vehicle("2vin1","2plate-1",1800));
        vehicleList2.add(new Vehicle("2vin2","2plate-2",1900));
        vehicleList2.add(new Vehicle("2vin3","2plate-3",2000));
        vehicleList2.add(new Vehicle("2vin4","2plate-4",2010));

        vehicleList3.add(new Vehicle("3vin1","3plate-1",1800));
        vehicleList3.add(new Vehicle("3vin2","3plate-2",1900));
        vehicleList3.add(new Vehicle("3vin1","3plate-1",1800));
        vehicleList3.add(new Vehicle("3vin2","3plate-2",1900));

        vehicleList4.add(new Vehicle("4vin1","4plate-1",1800));
        vehicleList4.add(new Vehicle("4vin2","4plate-2",1900));
        vehicleList4.add(new Vehicle("4vin1","4plate-1",1800));
        vehicleList4.add(new Vehicle("4vin2","4plate-2",1900));

        vehicleModelList.add(new VehicleModel("Model one", vehicleList));
        vehicleModelList.add(new VehicleModel("Model four", vehicleList4));
        vehicleModelList2.add(new VehicleModel("Model two", vehicleList2));
        vehicleModelList2.add(new VehicleModel("Model three", vehicleList3));

        vehicleMakeList.add(new VehicleMake("Make one", vehicleModelList));
        vehicleMakeList.add(new VehicleMake("Make two", vehicleModelList2));

        vehicleMakeService.saveVehicleMakeList(vehicleMakeList);

    }


}
