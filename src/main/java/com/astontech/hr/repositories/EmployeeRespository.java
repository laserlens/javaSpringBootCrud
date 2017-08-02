package com.astontech.hr.repositories;

import com.astontech.hr.domain.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRespository extends CrudRepository<Employee, Integer>{

    List<Employee> findAll();
}
