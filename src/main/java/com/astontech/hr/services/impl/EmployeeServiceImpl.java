package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Address;
import com.astontech.hr.domain.Employee;
import com.astontech.hr.domain.Project;
import com.astontech.hr.repositories.AddressRepository;
import com.astontech.hr.repositories.EmployeeRespository;
import com.astontech.hr.repositories.ProjectRepository;
import com.astontech.hr.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRespository employeeRespository;


    @Autowired
    public EmployeeServiceImpl(EmployeeRespository employeeRespository){
        this.employeeRespository = employeeRespository;

    }

    @Override
    public List<Employee> listAllEmployees() {
        return employeeRespository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRespository.findOne(id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRespository.save(employee);
    }

    @Override
    public Iterable<Employee> saveListOfEmployees(Iterable<Employee> employeeList) {
        return employeeRespository.save(employeeList);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRespository.delete(id);
    }

}
