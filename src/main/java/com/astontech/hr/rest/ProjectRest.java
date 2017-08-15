package com.astontech.hr.rest;

import com.astontech.hr.domain.Project;
import com.astontech.hr.services.ProjectService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectRest {
    private Logger log = Logger.getLogger(ProjectRest.class);

    private ProjectService projectService;

    @Autowired
    public ProjectRest(ProjectService projectService){
        this.projectService = projectService;
    }

    //returns all projects as a list
    @CrossOrigin
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Project> getAllProjects(){
        return projectService.listAllProjects();
    }

    //retuns projects by id
    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Project getProjectById(@PathVariable int id){
        return projectService.getProjectById(id);
    }

    //saves an Project
    @CrossOrigin
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Project saveProject(@RequestBody Project project) {
        return projectService.saveProject(project);
    }

    //delete project by id
    @CrossOrigin
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Boolean deleteProject(@PathVariable int id){
        boolean results = false;
        try {
            projectService.deleteProject(id);
            results = true;
        } catch (Exception ex){
            log.info(ex);

        }
        return results ;
    }

}
