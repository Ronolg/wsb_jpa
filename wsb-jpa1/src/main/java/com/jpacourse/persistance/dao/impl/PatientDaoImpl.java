package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.rest.exception.EntityNotFoundException;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Override
    public void addVisit(Long patientId, Long doctorId, LocalDateTime time, String description) {
        PatientEntity patientEntity = entityManager.find(PatientEntity.class, patientId);

        if (patientEntity == null) {
            throw new EntityNotFoundException(patientId);
        }

        DoctorEntity doctorEntity = entityManager.find(DoctorEntity.class, doctorId);

        if (doctorEntity == null) {
            throw new EntityNotFoundException(doctorId);
        }

        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setTime(time);
        visitEntity.setDescription(description);
        visitEntity.setDoctor(doctorEntity);
        visitEntity.setPatient(patientEntity);

        patientEntity.getVisits().add(visitEntity);
        doctorEntity.getVisits().add(visitEntity);

        entityManager.merge(patientEntity);
        entityManager.merge(doctorEntity);
    }
    @Override
    public List<PatientEntity> findByLastName(String lastName) {
        TypedQuery<PatientEntity> query = entityManager.createQuery(
                "SELECT p FROM PatientEntity p WHERE p.lastName = :lastName", PatientEntity.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }



    @Override
    public List<PatientEntity> findPatientsWithMoreThanXVisits(long numberOfVisits) {
        String jpql = "SELECT p FROM PatientEntity p WHERE SIZE(p.visits) > :numberOfVisits";
        return entityManager.createQuery(jpql, PatientEntity.class)
                .setParameter("numberOfVisits", numberOfVisits)
                .getResultList();
    }
    @Override
    public List<PatientEntity> findPatientsBornAfter(LocalDate date) {
        String jpql = "SELECT p FROM PatientEntity p WHERE p.dateOfBirth > :date";
        return entityManager.createQuery(jpql, PatientEntity.class)
                .setParameter("date", date)
                .getResultList();
    }

}
