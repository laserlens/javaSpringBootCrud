package respositories.services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.Employee;
import com.astontech.hr.domain.Project;
import com.astontech.hr.repositories.EmployeeRespository;
import com.astontech.hr.services.EmployeeService;
import com.astontech.hr.services.ProjectService;
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
public class ProjectServiceTest {

    private List<Project> projectList;
    private List<Employee> employeeList;
    private int id;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRespository employeeRespository;

    @Autowired
    private ProjectService projectService;

    @Before
    public void testSave() {
        projectList = new ArrayList<>();
        employeeList = new ArrayList<>();
        projectList.add(new Project( "project seven",  "client seven",  7));
        projectList.add(new Project( "project eight",  "client eight",  8));

        employeeList.add(new Employee( "FirstName two",  "LastName two",  "background two",  projectList));

        employeeService.saveListOfEmployees(employeeList);
        id = projectService.listAllProjects().get(0).getId();


    }

    @After
    public void tearDown() {
        employeeRespository.deleteAll();
    }

    @Test
    public void test_FindProjects() {
        Project project = projectService.getProjectById(id);
        assertNotNull(project);
        assertEquals("project seven",project.getProjectName());
    }

}