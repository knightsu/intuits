package com.intuit.cg.backendtechassessment.model;


import com.intuit.cg.backendtechassessment.util.CalUtil;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "project")
public class Project {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "proj_id", nullable = false, unique = true) private Long id;

    @Column(name = "detail") private String description;
    @Column(name = "max_budget") private Double mBudget;

    @Column(name = "deadline") private java.sql.Date deadline;  //the deadline is a date which means it will expire at 00:00 on that day
    @Column(name = "win_price") private Double winPrice;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getmBudget() {
        return mBudget;
    }

    public void setmBudget(Double mBudget) {
        this.mBudget = mBudget;
    }

    public String getDeadline() {
        return CalUtil.convert(this.deadline);
    }

    public void setDeadline(String deadline) {

        this.deadline = new java.sql.Date(CalUtil.convert(deadline).getTime());
    }

    public Double getWinPrice() {
        return winPrice;
    }

    public void setWinPrice(Double winPrice) {
        this.winPrice = winPrice;
    }
}
