package com.jpacourse.persistance.dao;


import com.jpacourse.persistance.entity.PatientEntity;


import java.time.LocalDateTime;

public interface PatientDao extends Dao<PatientEntity, Long> {
    void delete(Long id);
    void addVisit(Long patientId, Long doctorId, LocalDateTime time, String description);
}
