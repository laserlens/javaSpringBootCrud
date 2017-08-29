package com.astontech.hr.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee extends Person {

    private String background;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "personId")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Project> projects;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "personId")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Address> addressList;

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

    public Employee(String firstName, String lastName, List<Address> addressList) {
        super(firstName, lastName);
        this.addressList = addressList;
    }

    public Employee(String firstName, String lastName, String background, List<Project> projects, List<Address> addressList) {
        super(firstName, lastName);
        this.background = background;
        this.projects = projects;
        this.addressList = addressList;
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

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}
