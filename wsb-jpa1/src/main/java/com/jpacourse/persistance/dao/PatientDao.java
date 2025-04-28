package com.jpacourse.persistance.dao;


import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long> {
    void delete(Long id);
    void addVisit(Long patientId, Long doctorId, LocalDateTime time, String description);
    List<PatientEntity> findByLastName(String lastName);
    List<PatientEntity> findPatientsWithMoreThanXVisits(long numberOfVisits);
    List<PatientEntity> findPatientsBornAfter(LocalDate date);
}
