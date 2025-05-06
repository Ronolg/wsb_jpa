package com.jpacourse.rest;

import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.rest.exception.EntityNotFoundException;
import com.jpacourse.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/{patientId}/addVisit")
    public ResponseEntity<String> addPatientVisit(@PathVariable Long patientId, @RequestBody VisitEntity visitEntity)
    {
        try {
            patientService.addVisit(visitEntity);
            return new ResponseEntity<>("New visit added for the patient successfully", HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
