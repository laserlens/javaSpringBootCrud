package respositories.services;

import com.astontech.hr.application;
import com.astontech.hr.domain.Employee;
import com.astontech.hr.domain.Project;
import com.astontech.hr.repositories.EmployeeRespository;
import com.astontech.hr.services.EmployeeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Adrian.Flak on 7/11/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {application.class})
@WebAppConfiguration
public class EmployeeServiceTest {

    private List<Project> projectList;
    private List<Employee> employeeList;
    private int id;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRespository employeeRespository;

    @Before
    public void testSave(){
        projectList = new ArrayList<>();
        employeeList = new ArrayList<>();

        projectList.add(new Project( "project one",  "client one",  1));
        projectList.add(new Project( "project two",  "client two",  2));
        projectList.add(new Project( "project three",  "client three",  3));

        employeeList.add(new Employee( "FirstName one",  "LastName one",  "background one", projectList));
        employeeService.saveListOfEmployees(employeeList);
        id = employeeService.listAllEmployees().iterator().next().getId();


    }

    @After
    public void tearDown(){
        employeeRespository.deleteAll();
    }

    @Test
    public void testFindEmployeeAndPerson(){
        assertNotNull(employeeService.getEmployeeById(id));
        assertEquals("FirstName one",employeeService.getEmployeeById(id).getFirstName());
    }

    @Test
    public void testFindProjectsThroughEmployee() {
        assertNotNull(employeeService.getEmployeeById(id).getProjects());
        assertEquals(3,employeeService.getEmployeeById(id).getProjects().size());
    }




}
