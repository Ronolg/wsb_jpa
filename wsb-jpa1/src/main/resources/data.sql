insert into address (id, address_line1, address_line2, city, postal_code)
values (902, 'ul. Klonowa', 'lok. 4', 'Poznań', '60-123');

-- Pacjent
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, is_insured, address_id)
values (1001, 'John', 'Doe', '555-9876', 'john.doe@gmail.com', 'P12345', '1985-06-15', true, 902);

-- Lekarz
insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
values (901, 'Anna', 'Nowak', '555-1234', 'anna.nowak@clinic.com', 'D45678', 'GP', 902);

-- Wizyta
insert into visit (id, time, description, doctor_id, patient_id)
values (2001, '2025-03-01T10:00:00', 'Wizyta kontrolna', 901, 1001);

-- Zabieg
insert into medical_treatment (id, description, type, visit_id)
values (3001, 'Badanie USG brzucha', 'USG', 2001);