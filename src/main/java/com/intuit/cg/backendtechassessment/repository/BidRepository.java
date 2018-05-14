package com.intuit.cg.backendtechassessment.repository;

import com.intuit.cg.backendtechassessment.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BidRepository extends JpaRepository<Bid, Long> {
    @Query("select min(b.bidPrice) from Bid b where b.projId = :projid")
    double findMin(@Param("projid") long projectId);
}
