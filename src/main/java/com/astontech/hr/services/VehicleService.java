package com.astontech.hr.services;

import com.astontech.hr.domain.Vehicle;

/**
 * Created by Adrian.Flak on 7/11/2017.
 */
public interface VehicleService {

    Iterable<Vehicle> listAllVehicles();

    Vehicle getVehicleById(Integer id);

    Vehicle saveVehicle(Vehicle vehicle);

    Iterable<Vehicle> saveVehicleList(Iterable<Vehicle> vehicleList);

    void deleteVehicleById(Integer id);
}
