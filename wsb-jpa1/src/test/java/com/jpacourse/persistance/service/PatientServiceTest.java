package com.jpacourse.persistance.service;

import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.service.PatientService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Test
    @Transactional
    public void shouldFindVisitsByPatientId() {
        // given
        Long patientId = 1001L;

        // when
        List<VisitEntity> visits = patientService.findVisitsByPatientId(patientId);

        // then
        assertThat(visits).isNotEmpty();
        assertThat(visits.size()).isEqualTo(1);
    }
}