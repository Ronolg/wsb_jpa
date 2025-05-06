package com.jpacourse.mapper;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.persistance.enums.TreatmentType;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;

import java.util.List;

public class VisitMapper {

    public static VisitTO mapToTO(VisitEntity entity) {
        VisitTO to = new VisitTO();
        to.setTime(entity.getTime());

        if (entity.getDoctor() != null) {
            to.setDoctorFirstName(entity.getDoctor().getFirstName());
            to.setDoctorLastName(entity.getDoctor().getLastName());
        }

        if (entity.getMedicalTreatmentEntities() != null) {
            List<TreatmentType> types = entity.getMedicalTreatmentEntities().stream()
                    .map(MedicalTreatmentEntity::getType)
                    .toList();
            to.setTreatmentTypes(types);
        }

        return to;
    }
}