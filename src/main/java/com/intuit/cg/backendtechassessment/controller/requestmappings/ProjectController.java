package com.intuit.cg.backendtechassessment.controller.requestmappings;


import com.intuit.cg.backendtechassessment.model.Bid;
import com.intuit.cg.backendtechassessment.model.Buyer;
import com.intuit.cg.backendtechassessment.model.Project;
import com.intuit.cg.backendtechassessment.model.Seller;
import com.intuit.cg.backendtechassessment.service.api.BidService;
import com.intuit.cg.backendtechassessment.service.api.BuyerService;
import com.intuit.cg.backendtechassessment.service.api.ProjectService;
import com.intuit.cg.backendtechassessment.service.api.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class ProjectController {

    @Autowired
    BidService bidService;

    @Autowired
    BuyerService buyerService;

    @Autowired
    ProjectService projectService;

    @Autowired
    SellerService sellerService;


    @RequestMapping(value = RequestMappings.SELLERS, method = RequestMethod.POST)
    public Seller saveSeller(@RequestBody Seller seller)
    {
        sellerService.save(seller);
        return seller;
    }

    @RequestMapping(value = RequestMappings.BUYERS, method = RequestMethod.POST)
    public Buyer saveBuyer(@RequestBody Buyer buyer)
    {
        buyerService.save(buyer);
        return buyer;
    }

    @RequestMapping(value = RequestMappings.PROJECTS, method = RequestMethod.POST)
    public Project saveProject(@RequestBody Project project)
    {
        projectService.saveProj(project);
        return project;
    }

    @RequestMapping(value = RequestMappings.BIDS, method = RequestMethod.POST)
    public Bid saveBid(@RequestBody Bid bid)
    {
        bidService.saveBid(bid);
        return bid;
    }

    @RequestMapping(value = RequestMappings.PROJECTS + "/{projectId}", method = RequestMethod.GET)
    public Project getProject(@PathVariable long projectId)
    {
        return projectService.getProj(projectId);
    }



}
