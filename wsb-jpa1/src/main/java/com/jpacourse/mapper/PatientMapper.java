package com.jpacourse.mapper;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;
import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.entity.PatientEntity;

import java.util.List;

public class PatientMapper {
    public static PatientTO mapToTO(PatientEntity entity) {
        PatientTO to = new PatientTO();
        to.setId(entity.getId());
        to.setFirstName(entity.getFirstName());
        to.setLastName(entity.getLastName());


        if (entity.getVisits() != null) {
            List<VisitTO> visits = entity.getVisits().stream().map(visit -> {
                VisitTO vto = new VisitTO();
                vto.setTime(visit.getTime());
                vto.setDoctorFirstName(visit.getDoctor().getFirstName());
                vto.setDoctorLastName(visit.getDoctor().getLastName());
                vto.setTreatmentTypes(
                        visit.getMedicalTreatmentEntities().stream()
                                .map(MedicalTreatmentEntity::getType)
                                .toList());
                return vto;
            }).toList();
            to.setVisits(visits);
        }
        return to;
    }
}