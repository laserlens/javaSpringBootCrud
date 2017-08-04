package com.astontech.hr.rest;

import ch.qos.logback.core.subst.Tokenizer;
import com.astontech.hr.domain.Employee;
import com.astontech.hr.services.EmployeeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRest {
    private Logger log = Logger.getLogger(EmployeeRest.class);

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRest(EmployeeService employeeService){
        this.employeeService = employeeService;
    }


    //returns all employees as a list
    @CrossOrigin
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Employee> getAllEmployees(){
        return employeeService.listAllEmployees();
    }
    //retuns employee by id
    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }
    //saves an employee
    @CrossOrigin
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }
    //delete employee by id
    @CrossOrigin
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Boolean deleteEmployee(@PathVariable int id){
        boolean results = false;
        try {
            employeeService.deleteEmployee(id);
            results = true;
        } catch (Exception ex){
            log.info(ex);

        }
        return results ;
    }
}
