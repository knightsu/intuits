package com.intuit.cg.backendtechassessment.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

public class ProjRepositoryImpl implements ProjAssist {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional
    public int updateWinPrice(double winPrice, long projectId) {

        Query query = entityManager.createQuery("update Project p set p.winPrice = ?1 where p.id = ?2");
        query.setParameter(1, winPrice);
        query.setParameter(2, projectId);

        return query.executeUpdate();

    }


}
