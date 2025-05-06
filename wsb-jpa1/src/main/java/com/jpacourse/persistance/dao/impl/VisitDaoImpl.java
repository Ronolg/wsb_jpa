package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.VisitDao;
import com.jpacourse.persistance.entity.VisitEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VisitDaoImpl extends AbstractDao<VisitEntity, Long> implements VisitDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public VisitEntity findOne(Long id) {
        return entityManager.find(VisitEntity.class, id);
    }

    @Override
    public void delete(Long id) {
        VisitEntity entity = entityManager.find(VisitEntity.class, id);
        if (entity != null) entityManager.remove(entity);
    }

    @Override
    public List<VisitEntity> findAllByPatientId(Long patientId) {
        String jpql = "SELECT v FROM VisitEntity v WHERE v.patient.id = :patientId";
        return entityManager.createQuery(jpql, VisitEntity.class)
                .setParameter("patientId", patientId)
                .getResultList();
    }



}
