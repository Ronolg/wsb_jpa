insert into address (id, address_line1, address_line2, city, postal_code)
            values (901, 'xx', 'yy', 'city', '60-400');

insert into address (id, address_line1, address_line2, city, postal_code)
            values (902, 'ul. Zdrowa', 'blok 5', 'Kraków', '30-001');

insert into address (id, address_line1, address_line2, city, postal_code)
            values (903, 'ul. Chora', '4', 'Kraków', '30-001');

insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
            values (901, 'Miranda', 'Bailey', '555-5112', 'mirandabailey.gmail.com', '2', 'SURGEON', 903);

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
            values (1001, 'John', 'Doe', '555-9876', 'john.doe@gmail.com', 'P12345', '1985-06-15', 902);

insert into visit (id, description, time, doctor_id, patient_id)
            values (2, 'normal check up', '2025-03-20 14:30:00', 901, 1001);

insert into medical_treatment (id, description, type, visit_id)
            values (1, 'medical stuff', 'EKG', 2);
