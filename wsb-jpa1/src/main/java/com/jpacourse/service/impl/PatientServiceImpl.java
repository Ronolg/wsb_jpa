package com.jpacourse.service.impl;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.service.PatientService;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientDao patientDao;

    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public PatientTO getPatient(Long id) {
        return PatientMapper.mapToTO(patientDao.findOne(id));
    }

    @Override
    public void deletePatient(Long id) {
        patientDao.delete(id);
    }

    @Override
    public void addVisit(VisitEntity visitEntity) {
        patientDao.addVisit(visitEntity.getPatient().getId(),
                visitEntity.getDoctor().getId(),
                visitEntity.getTime(),
                visitEntity.getDescription());
    }
}
