package com.astontech.hr.controllers;


import com.astontech.hr.domain.VO.VehicleVO;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.VehicleModelService;

import com.astontech.hr.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * Created by Adrian.Flak on 7/11/2017.
 */
@Controller
public class VehicleController {

    private int saved = 0;
    private Integer makeId;
    private Integer modelId;
    private Integer vehicleId;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(value = "/admin/vehicle/add" , method = RequestMethod.GET)
    public String adminVehicleAdd(Model model) {
        informUserOfSave(model);

        model.addAttribute("vehicleVO", new VehicleVO());
        model.addAttribute("makeListAdd",vehicleMakeService.listAllVehicleMakes());

        return "admin/vehicle/vehicle_add";
    }

    @RequestMapping(value = "/admin/vehicle/add" , method = RequestMethod.POST)
    public String adminVehiclePost(VehicleVO vehicleVO) {

        vehicleMakeService.iterateThroughMakeListCheckifExistsSave(vehicleVO);
        saved+=1;

        return "redirect:add";
    }

    @RequestMapping(value = "/admin/vehicle/list", method = RequestMethod.GET)
    public String addminVehicleList(Model model) {

        model.addAttribute("vehicleMakeList", vehicleMakeService.findAll());

        return "admin/vehicle/vehicle_list";
    }

    @RequestMapping(value = "/admin/vehicle/delete/{id}", method = RequestMethod.GET)
    public String adminVehicleDelete(@PathVariable int id) {

        vehicleService.deleteVehicleById(id);

        return "redirect:/admin/vehicle/list";
    }

    @RequestMapping(value = "/admin/vehiclemodel/delete/{id}", method = RequestMethod.GET)
    public String adminVehicleModelDelete(@PathVariable int id) {

        vehicleModelService.deleteVehicleModelById(id);


        return "redirect:/admin/vehicle/list";
    }

    @RequestMapping(value = "/admin/vehiclemake/delete/{id}", method = RequestMethod.GET)
    public String adminVehicleMakeDelete(@PathVariable int id) {

        vehicleMakeService.deleteVehicleMakeById(id);

        return "redirect:/admin/vehicle/list";
    }

    @RequestMapping(value = "/admin/vehicle/edit/{makeId_modelId_vehicleId}", method = RequestMethod.GET)
    public String adminVehicleMakeUpdate(@PathVariable String makeId_modelId_vehicleId,Model model) {
        String [] ids = stringSpliter(makeId_modelId_vehicleId);
        makeId = Integer.parseInt(ids[0]);
        modelId = Integer.parseInt(ids[1]);
        vehicleId = Integer.parseInt(ids[2]);

        model.addAttribute("makeListEdit",vehicleMakeService.listAllVehicleMakes());
        model.addAttribute("vehicleVO", new VehicleVO());

        model.addAttribute("makeEdit",vehicleMakeService.getVehicleMakeById(makeId));
        model.addAttribute("modelEdit",vehicleModelService.getVehicleModelById(modelId));
        model.addAttribute("vehicleEdit",vehicleService.getVehicleById(vehicleId));

        return "admin/vehicle/vehicle_edit";
    }

    @RequestMapping(value = "/admin/vehicle/edit", method = RequestMethod.POST)
    public String adminVehicleMakeUpdatePost(VehicleVO vehicleVO){
      vehicleMakeService.updateVehicleMAke(vehicleVO,makeId,modelId,vehicleId);

        return "redirect:list";
    }

    //region Helper Methods

    //timer method to inform user input was saved
    private void informUserOfSave(Model model){
        if(saved > 0)
        model.addAttribute("successMsg", saved + " Vehicles Saved");
    }

    private String[] stringSpliter(String s){
        return s.split("_");
    }


    //endregion

}