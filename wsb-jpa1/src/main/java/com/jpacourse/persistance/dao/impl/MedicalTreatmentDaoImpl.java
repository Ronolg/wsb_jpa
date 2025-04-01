package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.Dao;
import com.jpacourse.persistance.dao.MedicalTreatmentDao;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MedicalTreatmentDaoImpl extends AbstractDao<MedicalTreatmentEntity, Long> implements MedicalTreatmentDao
{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public MedicalTreatmentEntity findOne(Long id) {
        return entityManager.find(MedicalTreatmentEntity.class, id);
    }


}
