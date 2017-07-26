package com.astontech.hr.services;

import com.astontech.hr.domain.VO.VehicleVO;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;

import java.util.List;

/**
 * Created by Adrian.Flak on 7/11/2017.
 */
public interface VehicleMakeService {

    Iterable<VehicleMake> listAllVehicleMakes();

    VehicleMake getVehicleMakeById(Integer id);

    VehicleMake saveVehicleMake(VehicleMake vehicleMake);

    Iterable<VehicleMake> saveVehicleMakeList(Iterable<VehicleMake> vehicleMakeList);

    void deleteVehicleMakeById(Integer id);

    List<VehicleMake> findAll();

    VehicleMake iterateThroughMakeListCheckifExistsSave(VehicleVO vehicleVO);

    VehicleMake updateVehicleMAke(VehicleVO vehicleVO, Integer makeId, Integer modelId, Integer vehicleId);
}
