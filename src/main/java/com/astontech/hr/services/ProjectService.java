package com.astontech.hr.services;

import com.astontech.hr.domain.Project;

import java.util.List;

public interface ProjectService {

    List<Project> listAllProjects ();
    Project getProjectById (Integer id);

    Project saveProject(Project Project);
    Iterable<Project> saveListOfProjects(Iterable<Project> ProjectList);

    void deleteProject(Integer id);
}
