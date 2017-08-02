package com.astontech.hr.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee extends Person {

    private String background;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PersonId")
    private List<Project> projects;

    public Employee(){}

    public Employee(String firstName, String lastName, String background) {
        super(firstName, lastName);
        this.background = background;
    }

    public Employee(String firstName, String lastName, String background, List<Project> projects) {
        super(firstName, lastName);
        this.background = background;
        this.projects = projects;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
