package com.jpacourse.persistance.entity;

import java.time.LocalDateTime;
import java.util.Collection;

import jakarta.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOCTOR_ID")
	private DoctorEntity doctor;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "VISIT_ID")
	private Collection<MedicalTreatmentEntity> medicalTreatmentEntities;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public DoctorEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

	public Collection<MedicalTreatmentEntity> getMedicalTreatmentEntities() {
		return medicalTreatmentEntities;
	}

	public void setMedicalTreatmentEntities(Collection<MedicalTreatmentEntity> medicalTreatmentEntities) {
		this.medicalTreatmentEntities = medicalTreatmentEntities;
	}
}
