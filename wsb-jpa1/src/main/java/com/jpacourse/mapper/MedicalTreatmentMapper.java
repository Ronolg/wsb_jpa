package com.jpacourse.mapper;

import com.jpacourse.dto.MedicalTreatmentTO;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;

public class MedicalTreatmentMapper {
    public static MedicalTreatmentTO mapToTO(MedicalTreatmentEntity entity) {
        MedicalTreatmentTO to = new MedicalTreatmentTO();
        to.setDescription(entity.getDescription());
        to.setType(entity.getType());
        return to;
    }
}