# momlife
DEMO App for tracking and editing pregnancy of patients

* Spring Data JPA
* Spring WEB
* PostgreSQL

* Thymeleaf
* Flyway

* Bootstrap
* Bootstrap datepicker

* tablesorter.js

REST API:

- "/" - get all patient list 
- "patient/{patient_id}/pregnancies" - all pregnancies of patient with id = patient_id
- "patient/{patient_id}/add/pregnancy" - adding pregnancy to patient with id = patient_id. 
                                       if patient has pregnancy with status = 'active', patient cannot add pregnancy   
- "patient/{patient_id}/pregnancy/{pregnancy_id}/delete" - deleting pregnancy
- "/patient/{patient_id}/pregnancy/{pregnancy_id}/edit" - completing pregnancy

port : 8080

