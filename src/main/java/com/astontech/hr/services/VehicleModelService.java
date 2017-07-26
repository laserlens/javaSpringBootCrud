package com.astontech.hr.services;

import com.astontech.hr.domain.VehicleModel;

/**
 * Created by Adrian.Flak on 7/11/2017.
 */
public interface VehicleModelService {

    Iterable<VehicleModel> listAllVehicleModel();

    VehicleModel getVehicleModelById(Integer id);

    VehicleModel saveVehicleModel(VehicleModel vehicleModel);

    Iterable<VehicleModel> saveVehicleModel(Iterable<VehicleModel> vehicleModelList);

    void deleteVehicleModelById(Integer id);
}
