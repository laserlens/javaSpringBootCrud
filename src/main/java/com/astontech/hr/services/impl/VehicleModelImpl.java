package com.astontech.hr.services.impl;

import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.repositories.VehicleModelRepository;
import com.astontech.hr.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Adrian.Flak on 7/11/2017.
 */
@Service
public class VehicleModelImpl implements VehicleModelService {

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    @Override
    public Iterable<VehicleModel> listAllVehicleModel() {
        return vehicleModelRepository.findAll();
    }

    @Override
    public VehicleModel getVehicleModelById(Integer id) {
        return vehicleModelRepository.findOne(id);
    }

    @Override
    public VehicleModel saveVehicleModel(VehicleModel vehicleModel) {
        return vehicleModelRepository.save(vehicleModel);
    }

    @Override
    public Iterable<VehicleModel> saveVehicleModel(Iterable<VehicleModel> vehicleModelList) {
        return vehicleModelRepository.save(vehicleModelList);
    }

    @Override
    public void deleteVehicleModelById(Integer id) {
        vehicleModelRepository.delete(id);

    }
}
