package com.intuit.cg.backendtechassessment.repository;

import com.intuit.cg.backendtechassessment.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface ProjRepository extends ProjAssist, JpaRepository<Project, Long> {
    Project getProjectById(long projectId);
    @Query("select p from Project p where p.deadline = CURRENT_DATE")
    List<Project> getTerminatedProjects();
}
