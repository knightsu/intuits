package com.intuit.cg.backendtechassessment.service.impl;

import com.intuit.cg.backendtechassessment.model.Seller;
import com.intuit.cg.backendtechassessment.repository.SellerRepository;
import com.intuit.cg.backendtechassessment.service.api.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public void save(Seller seller) {
        sellerRepository.save(seller);
    }
}
