package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Project;
import com.astontech.hr.repositories.ProjectRepository;
import com.astontech.hr.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRespository;

    @Override
    public List<Project> listAllProjects() {
        return projectRespository.findAll();
    }

    @Override
    public Project getProjectById(Integer id) {
        return projectRespository.findOne(id);
    }

    @Override
    public Project saveProject(Project project) {
        return projectRespository.save(project);
    }

    @Override
    public Iterable<Project> saveListOfProjects(Iterable<Project> projectList) {
        return projectRespository.save(projectList);
    }

    @Override
    public void deleteProject(Integer id) {
        projectRespository.delete(id);
    }
}
