package com.intuit.cg.backendtechassessment.model;

import javax.persistence.*;

@Entity
@Table(name = "bid")
public class Bid {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "bid_id", nullable = false, unique = true) private Long id;

    @Column(name = "p_id", nullable = false) private Long projId;
    @Column(name = "b_id", nullable = false) private Long buyId;

    @Column(name = "bid_price", nullable = false) private Double bidPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjId() {
        return projId;
    }

    public void setProjId(Long projId) {
        this.projId = projId;
    }

    public Long getBuyId() {
        return buyId;
    }

    public void setBuyId(Long buyId) {
        this.buyId = buyId;
    }

    public Double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
    }
}
