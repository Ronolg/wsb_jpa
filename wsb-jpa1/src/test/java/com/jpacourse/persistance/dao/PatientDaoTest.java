package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.AddressEntity;

import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.PatientEntity;

import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.persistance.enums.Specialization;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;
    @Autowired
    private AddressDao addressDao;

    @Autowired
    private  DoctorDao doctorDao;

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

    @Transactional
    @Test
    public void testShouldAddPatientVisit() {
        // given
        AddressEntity patientAddress = new AddressEntity();
        patientAddress.setAddressLine1("Testowa");
        patientAddress.setAddressLine2("1A");
        patientAddress.setCity("Miasto");
        patientAddress.setPostalCode("00-000");
        addressDao.save(patientAddress);

        AddressEntity doctorAddress = new AddressEntity();
        doctorAddress.setAddressLine1("Testowa");
        doctorAddress.setAddressLine2("3A");
        doctorAddress.setCity("Miasto");
        doctorAddress.setPostalCode("00-000");
        addressDao.save(doctorAddress);

        PatientEntity patient = new PatientEntity();
        patient.setFirstName("Anna");
        patient.setLastName("Nowak");
        patient.setTelephoneNumber("123456789");
        patient.setEmail("anna.nowak@example.com");
        patient.setPatientNumber("PN001");
        patient.setDateOfBirth(LocalDate.of(1990, 1, 1));
        patient.setAddress(patientAddress);
        patientDao.save(patient);

        DoctorEntity doctor = new DoctorEntity();
        doctor.setFirstName("Jan");
        doctor.setLastName("Kowalski");
        doctor.setTelephoneNumber("987654321");
        doctor.setEmail("jan.kowalski@example.com");
        doctor.setDoctorNumber("DR001");
        doctor.setSpecialization(Specialization.SURGEON);
        doctor.setAddress(doctorAddress);
        doctorDao.save(doctor);

        final Long patientId = patient.getId();
        final Long doctorId = doctor.getId();

        // when
        patientDao.addVisit(patientId, doctorId, LocalDateTime.of(2025, 1, 1, 15, 30), "hip surgery");

        // then
        assertThat(patient.getVisits()).isNotEmpty();
        assertThat(doctor.getVisits()).isNotEmpty();
    }
    @Transactional
    @Test
    public void shouldFindPatientsByLastName() {
        // when
        List<PatientEntity> patients = patientDao.findByLastName("Doe");

        // then
        assertThat(patients).isNotNull();
        assertThat(patients.size()).isEqualTo(1);
    }
    @Transactional
    @Test
    public void shouldFindPatientsWithMoreThanXVisits() {
        // given
        long minVisits = 0;

        // when
        List<PatientEntity> patients = patientDao.findPatientsWithMoreThanXVisits(minVisits);

        // then
        assertThat(patients).isNotEmpty();
    }

    @Transactional
    @Test
    public void shouldFindPatientsBornAfterDate() {
        // given
        LocalDate date = LocalDate.of(1980, 1, 1); // zamiast 1990

        // when
        List<PatientEntity> patients = patientDao.findPatientsBornAfter(date);

        // then
        assertThat(patients).isNotEmpty();
    }

}
