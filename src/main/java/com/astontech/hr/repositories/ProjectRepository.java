package com.astontech.hr.repositories;

import com.astontech.hr.domain.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project,Integer> {

    List<Project> findAll();
}
