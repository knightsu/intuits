package com.intuit.cg.backendtechassessment.service.api;

import com.intuit.cg.backendtechassessment.model.Bid;

public interface BidService {
    void saveBid(Bid bid);
    double findMin(long projectId);
}
