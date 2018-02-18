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

