package com.intuit.cg.backendtechassessment.model;

import javax.persistence.*;

@Entity
@Table(name = "buyers")
public class Buyer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "buyer_id", nullable = false, unique = true) private Long id;
    @Column(name = "buyer_name", nullable = false, unique = true) private String name;

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
}
