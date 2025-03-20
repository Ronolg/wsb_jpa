insert into address (id, address_line1, address_line2, city, postal_code)
            values (901, 'xx', 'yy', 'city', '60-400');

insert into address (id, address_line1, address_line2, city, postal_code)
values (902, 'ul. Zdrowa', 'blok 5', 'Kraków', '30-001');
--insert into doctor (id, firstName, lastName, telephoneNumber, email, doctorNumber, specialization)
--            values (901, 'Miranda', 'Bailey', '555-5112', 'mirandabailey.gmail.com', '2', 'SURGEON');
--
--insert into address (id, city , addressLine1, addressLine2, postal_code)
--            values ();
--
--insert into visits (id, description, time, doctor_id)
--            values (2, 'normal check up', , 901);
--
--insert into medical_treatment (id, description, type, visit_id)
--            values ();

-- Pacjent
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
values (1001, 'John', 'Doe', '555-9876', 'john.doe@gmail.com', 'P12345', '1985-06-15', 902);
