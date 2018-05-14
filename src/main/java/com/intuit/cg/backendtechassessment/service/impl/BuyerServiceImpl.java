package com.intuit.cg.backendtechassessment.service.impl;

import com.intuit.cg.backendtechassessment.model.Buyer;
import com.intuit.cg.backendtechassessment.repository.BuyerRepository;
import com.intuit.cg.backendtechassessment.service.api.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    BuyerRepository buyerRepository;

    @Override
    public void save(Buyer buyer) {
        buyerRepository.save(buyer);
    }
}
