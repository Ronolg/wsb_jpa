package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.persistance.dao.PatientDao;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public interface PatientService {
    PatientTO getPatient(Long id);
    void deletePatient(Long id);
    void addVisit(Long patientId, Long doctorId, LocalDateTime time, String description);
}
