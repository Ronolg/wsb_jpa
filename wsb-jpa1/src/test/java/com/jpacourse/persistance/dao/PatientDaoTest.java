package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.AddressEntity;

import com.jpacourse.persistance.entity.PatientEntity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;
    @Autowired
    private AddressDao addressDao;

    @Transactional
    @Test
    public void testShouldDeletePatient() {
        // given
        AddressEntity address = new AddressEntity();
        address.setAddressLine1("Testowa");
        address.setAddressLine2("1A");
        address.setCity("Miasto");
        address.setPostalCode("00-000");
        addressDao.save(address);

        PatientEntity patient = new PatientEntity();
        patient.setFirstName("Anna");
        patient.setLastName("Nowak");
        patient.setTelephoneNumber("123456789");
        patient.setEmail("anna.nowak@example.com");
        patient.setPatientNumber("PN001");
        patient.setDateOfBirth(LocalDate.of(1990, 1, 1));

        patient.setAddress(address);
        patientDao.save(patient);

        Long patientId = patient.getId();
        assertThat(patientDao.findOne(patientId)).isNotNull();

        // when
        patientDao.delete(patientId);

        // then
        assertThat(patientDao.findOne(patientId)).isNull();
    }
}
