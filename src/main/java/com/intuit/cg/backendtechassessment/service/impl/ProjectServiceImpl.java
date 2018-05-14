package com.intuit.cg.backendtechassessment.service.impl;

import com.intuit.cg.backendtechassessment.model.Project;
import com.intuit.cg.backendtechassessment.repository.ProjRepository;
import com.intuit.cg.backendtechassessment.service.api.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjRepository projRepository;

    @Override
    public void saveProj(Project project) {
        projRepository.save(project);
    }

    @Override
    public Project getProj(long projectId) {
        return projRepository.getProjectById(projectId);
    }

    @Override
    public int updateWinPrice(double winPrice, long projectId) {
        return projRepository.updateWinPrice(winPrice, projectId);
    }

    @Override
    public List<Project> findTerminatedProject() {
        return projRepository.getTerminatedProjects();
    }
}
