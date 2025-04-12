package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.rest.exception.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;

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
}
