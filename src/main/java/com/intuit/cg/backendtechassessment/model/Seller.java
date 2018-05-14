package com.intuit.cg.backendtechassessment.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "seller")
public class Seller {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "seller_id", nullable = false, unique = true) private Long id;

    @Column(name = "seller_name", nullable = false, unique = true) private String name;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "seller")
//    private List<Project> projects;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Project> getProjects() {
//        return projects;
//    }
//
//    public void setProjects(List<Project> projects) {
//        this.projects = projects;
//    }
}
