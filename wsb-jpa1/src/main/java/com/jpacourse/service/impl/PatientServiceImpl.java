package com.jpacourse.service.impl;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.dao.VisitDao;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientDao patientDao;
    private VisitDao visitDao;

    public PatientServiceImpl(PatientDao patientDao, VisitDao visitDao) {

        this.patientDao = patientDao;
        this.visitDao = visitDao;
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

    @Override
    public List<VisitEntity> findVisitsByPatientId(Long patientId) {
        return visitDao.findAllByPatientId(patientId);
    }
}
