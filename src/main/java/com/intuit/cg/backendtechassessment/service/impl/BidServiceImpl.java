package com.intuit.cg.backendtechassessment.service.impl;

import com.intuit.cg.backendtechassessment.exception.Error;
import com.intuit.cg.backendtechassessment.exception.PassDeadlineException;
import com.intuit.cg.backendtechassessment.model.Bid;
import com.intuit.cg.backendtechassessment.model.Project;
import com.intuit.cg.backendtechassessment.repository.BidRepository;
import com.intuit.cg.backendtechassessment.repository.ProjRepository;
import com.intuit.cg.backendtechassessment.service.api.BidService;
import com.intuit.cg.backendtechassessment.util.CalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Calendar;
import java.util.Date;


@Service
public class BidServiceImpl implements BidService {

    @Autowired
    BidRepository bidRepository;
    @Autowired
    ProjRepository projRepository;

    @Override
    public void saveBid(Bid bid) {
        //check the new bid to see if it pass deadline
        long projectId = bid.getProjId();
        Project project = projRepository.getProjectById(projectId);
        Date date = new Date();
        Date dealine = CalUtil.convert(project.getDeadline());
        Calendar c = Calendar.getInstance();
        c.setTime(dealine); c.add(Calendar.DATE, 1);
        dealine = c.getTime();
        if(dealine.compareTo(date)<0) throw new PassDeadlineException();
        bidRepository.save(bid);
    }

    @Override
    public double findMin(long projectId) {
        double res = bidRepository.findMin(projectId);
        return res;
    }


    @ExceptionHandler(PassDeadlineException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error passDeadline(PassDeadlineException e)
    {
        return new Error(4, "pass deadline");
    }
}
