package com.intuit.cg.backendtechassessment.service.api;

import com.intuit.cg.backendtechassessment.model.Project;

import java.util.List;

public interface ProjectService {
    void saveProj(Project project);
    Project getProj(long projectId);
    int updateWinPrice(double winPrice, long projectId);
    List<Project> findTerminatedProject();
}
