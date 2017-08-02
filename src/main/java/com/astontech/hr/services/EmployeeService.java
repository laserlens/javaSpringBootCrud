package com.astontech.hr.services;

import com.astontech.hr.domain.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> listAllEmployees ();
    Employee getEmployeeById (Integer Id);

    Employee saveEmployee(Employee employee);
    Iterable<Employee> saveListOfEmployees(Iterable<Employee> employeeList);

    void deleteEmployee(Integer id);
}
