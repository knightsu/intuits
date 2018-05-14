package com.intuit.cg.backendtechassessment.controller.requestmappings;

import com.intuit.cg.backendtechassessment.exception.Error;
import com.intuit.cg.backendtechassessment.exception.UpdateFailException;
import com.intuit.cg.backendtechassessment.model.Project;
import com.intuit.cg.backendtechassessment.service.api.BidService;
import com.intuit.cg.backendtechassessment.service.api.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class BatchController {

    @Autowired
    BidService bidService;

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/cal", method = RequestMethod.GET)
    public void calculate()
    {
        List<Project> projects = projectService.findTerminatedProject();
        for(Project project : projects)
        {
            double price = bidService.findMin(project.getId());
            int num = projectService.updateWinPrice(price, project.getId());

            //handle exception
            if(num != 1) throw new UpdateFailException();
        }
    }

    @ExceptionHandler(UpdateFailException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error updateFail(UpdateFailException e)
    {
        return new Error(4, "win price update failed");
    }
}
