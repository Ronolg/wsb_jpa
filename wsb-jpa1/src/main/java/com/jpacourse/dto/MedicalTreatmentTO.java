package com.jpacourse.dto;

import com.jpacourse.persistance.enums.TreatmentType;

public class MedicalTreatmentTO {
    private String description;
    private TreatmentType type;

    public TreatmentType getType() {
        return type;
    }

    public void setType(TreatmentType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
