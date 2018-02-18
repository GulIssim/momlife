CREATE TABLE patient (
  id INTEGER ,
  iin varchar(50) NOT NULL,
  full_name varchar(50) DEFAULT NULL,
  CONSTRAINT patient_pkey PRIMARY KEY (id)
);

CREATE TABLE pregnancy (
  id INTEGER ,
  status varchar(50) NOT NULL,
  patient_id INTEGER,
  start_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  end_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (patient_id)
  REFERENCES public.patient(id));

INSERT INTO patient VALUES (1, '123456789123', 'Sit Amet'), (2, '789456123789', 'Lorem Ipsum');
INSERT INTO pregnancy VALUES (1, 'active', 1, '17-09-2012','17-6-2013'), (2,'success',2, '20-02-2015', '18-11-2015');

