package respositories.services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.Address;
import com.astontech.hr.domain.Contact;
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
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class EmployeeServiceTest {

    private int id;
    private int empId;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRespository employeeRespository;

    @Before
    public void setUp(){

        List<Project> projectList = new ArrayList<>();
        List<Employee> employeeList = new ArrayList<>();
        List<Address> addressList = new ArrayList<>();

        addressList.add(new Address("Home","1 st N","OneVille","MN","11111"));
        addressList.add(new Address("Office","2 st N","TwoVille","WI","22222"));

        projectList.add(new Project( "project one",  "client one",  1));
        projectList.add(new Project( "project two",  "client two",  2));
        projectList.add(new Project( "project three",  "client three",  3));

        employeeList.add(new Employee( "FirstName one",  "LastName one",  "background one", projectList, addressList));
        employeeService.saveListOfEmployees(employeeList);
        id = employeeService.listAllEmployees().iterator().next().getId();
        empId = employeeService.getEmployeeById(id).getProjects().iterator().next().getId();

    }

    @After
    public void tearDown(){
        employeeRespository.deleteAll();
    }

    @Test
    public void test_FindEmployeeAndPerson(){
        assertNotNull(employeeService.getEmployeeById(id));
        assertEquals("FirstName one",employeeService.getEmployeeById(id).getFirstName());
    }

    @Test
    public void test_FindProjectsThroughEmployee() {
        List<Project> projectList =employeeService.getEmployeeById(id).getProjects();
        assertNotNull(projectList);
        assertEquals(6,projectList.size());
        for (Project project:
             projectList) {
            System.out.println(project.getProjectName());
        }
    }

    @Test
    public void test_FindAddressThroughEmployee(){
        assertNotNull(employeeService.getEmployeeById(id).getAddressList());
        assertEquals(6,employeeService.getEmployeeById(id).getAddressList().size());
    }




}
