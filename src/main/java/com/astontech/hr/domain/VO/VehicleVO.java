package com.astontech.hr.domain.VO;

/**
 * Created by Adrian.Flak on 7/11/2017.
 */
public class VehicleVO {

    private String newVehicleMake;
    private String vehicleMakeId;
    private String vehicleModelId;
    private String newVehicleModel;
    private String newVehicleVin;
    private String newVehicleLicensePlate;
    private String newVehicleYear;

    public VehicleVO(){}

    public String getNewVehicleMake() {
        return newVehicleMake;
    }

    public void setNewVehicleMake(String newVehicleMake) {
        this.newVehicleMake = newVehicleMake;
    }

    public String getNewVehicleModel() {
        return newVehicleModel;
    }

    public void setNewVehicleModel(String newVehicleModel) {
        this.newVehicleModel = newVehicleModel;
    }

    public String getNewVehicleVin() {
        return newVehicleVin;
    }

    public void setNewVehicleVin(String newVehicleVin) {
        this.newVehicleVin = newVehicleVin;
    }

    public String getNewVehicleLicensePlate() {
        return newVehicleLicensePlate;
    }

    public void setNewVehicleLicensePlate(String newVehicleLicensePlate) {
        this.newVehicleLicensePlate = newVehicleLicensePlate;
    }

    public String getNewVehicleYear() {
        return newVehicleYear;
    }

    public void setNewVehicleYear(String newVehicleYear) {
        this.newVehicleYear = newVehicleYear;
    }

    public String getVehicleMakeId() {
        return vehicleMakeId;
    }

    public void setVehicleMakeId(String vehicleMakeId) {
        this.vehicleMakeId = vehicleMakeId;
    }

    public String getVehicleModelId() {
        return vehicleModelId;
    }

    public void setVehicleModelId(String vehicleModelId) {
        this.vehicleModelId = vehicleModelId;
    }
}
