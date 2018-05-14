package com.intuit.cg.backendtechassessment.repository;

import com.intuit.cg.backendtechassessment.model.Project;

import java.sql.Date;
import java.util.List;

public interface ProjAssist {
    int updateWinPrice(double winPrice, long projectId);

}
