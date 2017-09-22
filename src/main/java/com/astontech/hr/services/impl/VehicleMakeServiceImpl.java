package com.astontech.hr.services.impl;

import com.astontech.hr.domain.VO.VehicleVO;
import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.repositories.VehicleMakeRepository;
import com.astontech.hr.repositories.VehicleModelRepository;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian.Flak on 7/11/2017.
 */
@Service
public class VehicleMakeServiceImpl implements VehicleMakeService {


    private VehicleMakeRepository vehicleMakeRepository;
    private VehicleModelRepository vehicleModelRepository;
    private VehicleService vehicleService;

    private final Object key = new Object();//object used to store value of the key.


    @Autowired
    public VehicleMakeServiceImpl(VehicleMakeRepository vehicleMakeRepository, VehicleModelRepository vehicleModelRepository,
                                  VehicleService vehicleService){
        this.vehicleMakeRepository = vehicleMakeRepository;
        this.vehicleService = vehicleService;
        this.vehicleModelRepository = vehicleModelRepository;
    }



    @Override
    public Iterable<VehicleMake> listAllVehicleMakes() {
        return vehicleMakeRepository.findAll();
    }

    @Override
    public VehicleMake getVehicleMakeById(Integer id) {
        return vehicleMakeRepository.findOne(id);
    }

    @Override
    public VehicleMake saveVehicleMake(VehicleMake vehicleMake) {
        return vehicleMakeRepository.save(vehicleMake);
    }

    @Override
    public Iterable<VehicleMake> saveVehicleMakeList(Iterable<VehicleMake> vehicleMakeList) {
        return vehicleMakeRepository.save(vehicleMakeList);
    }

    @Override
    public void deleteVehicleMakeById(Integer id) {
        vehicleMakeRepository.delete(id);
    }

    @Override
    public List<VehicleMake> findAll() {
        return vehicleMakeRepository.findAll();
    }


    @Override
    public VehicleMake iterateThroughMakeListCheckifExistsSave(VehicleVO vehicleVO){
            VehicleMake newVehicleMake = makeANewVehicle(vehicleVO);
            List<VehicleMake> compareMakeList = vehicleMakeRepository.findAll();

            for (VehicleMake vMake : compareMakeList ) {
                  if (vMake.getVehicleMakeName().equalsIgnoreCase(vehicleVO.getNewVehicleMake())){

                      VehicleMake matchingMake = vehicleMakeRepository.findOne(vMake.getId());

                      for(VehicleModel vModel : matchingMake.getModelList() ){
                          if (vModel.getVehicleModelName().equalsIgnoreCase(vehicleVO.getNewVehicleModel())){

                              vModel.getVehicleList().add(newVehicleMake.getModelList().get(0).getVehicleList().get(0));
                              return vehicleMakeRepository.save(matchingMake);
                          }
                      }

                      matchingMake.getModelList().add(new VehicleModel(vehicleVO.getNewVehicleModel(),
                            newVehicleMake.getModelList().get(0).getVehicleList()));

                      return vehicleMakeRepository.save(matchingMake);

                  }
            }

        return vehicleMakeRepository.save(newVehicleMake);
    }

    @Override
    public VehicleMake updateVehicleMAke(VehicleVO vehicleVO, Integer makeId, Integer modelId, Integer vehicleId){
        synchronized (key){//practice using synchronized
            VehicleMake updateThisVehicle = vehicleMakeRepository.findOne(makeId);
            VehicleModel orginalModel = vehicleModelRepository.findOne(modelId);
            Vehicle orginalVehicle = vehicleService.getVehicleById(vehicleId);

            // TODO: 8/29/17 refactor redundent code and anything that uses the variables
            //region repetitive code not needed
            VehicleModel updatedModel =  updateThisVehicle.getModelList().get(updateThisVehicle.getModelList().indexOf(orginalModel));
            Vehicle updatedVehicle =  updatedModel.getVehicleList().get(updatedModel.getVehicleList().indexOf(orginalVehicle));
            //endregion

            if(!orginalModel.getVehicleModelName().equalsIgnoreCase(vehicleVO.getNewVehicleModel())
                    ||!updateThisVehicle.getVehicleMakeName().equalsIgnoreCase(vehicleVO.getNewVehicleMake())){

                updateThisVehicle.getModelList().get(updateThisVehicle.getModelList().indexOf(orginalModel))
                        .getVehicleList().remove(orginalVehicle);//remove original vehicle

                vehicleMakeRepository.save(updateThisVehicle);//save removal
                return iterateThroughMakeListCheckifExistsSave(vehicleVO);//create new vehicle make or mdoel
            }else {

                updatedVehicle.setVin(vehicleVO.getNewVehicleVin());//set vin
                updatedVehicle.setLicensePlate(vehicleVO.getNewVehicleLicensePlate());//set plate
                updatedVehicle.setYear(Integer.parseInt(vehicleVO.getNewVehicleYear()));//set year
                return vehicleMakeRepository.save(updateThisVehicle);
            }
        }

    }

    //region Helper Methods

    //takes VehicleVo from user input and makes a new Vehicle Make
    private VehicleMake makeANewVehicle(VehicleVO vehicleVO){

        List<Vehicle> newVehicleList = new ArrayList<>();
        Vehicle newVehicle = new Vehicle();
        newVehicle.setLicensePlate(vehicleVO.getNewVehicleLicensePlate());
        newVehicle.setVin(vehicleVO.getNewVehicleVin());
        newVehicle.setYear(Integer.parseInt(vehicleVO.getNewVehicleYear()));
        newVehicleList.add(newVehicle);


        List<VehicleModel> newVehicleModelList = new ArrayList<>();
        VehicleModel newVehicleModel = new VehicleModel();
        newVehicleModel.setVehicleModelName(vehicleVO.getNewVehicleModel());
        newVehicleModel.setVehicleList(newVehicleList);
        newVehicleModelList.add(newVehicleModel);


        VehicleMake newVehicleMake = new VehicleMake();
        newVehicleMake.setVehicleMakeName(vehicleVO.getNewVehicleMake());
        newVehicleMake.setModelList(newVehicleModelList);

        return newVehicleMake;
    }
    //endregion
}
