package com.astontech.hr.repositories;

import com.astontech.hr.domain.VehicleMake;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Adrian.Flak on 7/11/2017.
 */
public interface VehicleMakeRepository extends CrudRepository<VehicleMake,Integer> {

    //return a list
    List<VehicleMake> findAll ();
}
