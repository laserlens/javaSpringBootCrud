package com.astontech.hr.domain;

import javax.persistence.*;


/**
 * Created by Adrian.Flak on 7/11/2017.
 */
@Entity
//@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicleId")
    private Integer id;

    @Version
    private Integer version;

    private String vin;

    private String licensePlate;

    private Integer year;

    public Vehicle(){}

    public Vehicle(String vin,String licensePlate,Integer year){
        this.setVin(vin);
        this.setLicensePlate(licensePlate);
        this.setYear(year);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }


}
