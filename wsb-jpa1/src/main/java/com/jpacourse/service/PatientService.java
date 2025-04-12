package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistance.entity.VisitEntity;
import org.springframework.stereotype.Service;

@Service
public interface PatientService {
    PatientTO getPatient(Long id);
    void deletePatient(Long id);
    void addVisit(VisitEntity visitEntity);
}
