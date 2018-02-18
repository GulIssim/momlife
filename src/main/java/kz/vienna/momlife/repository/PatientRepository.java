package kz.vienna.momlife.repository;

import kz.vienna.momlife.model.entity.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientRepository extends CrudRepository<Patient, Long> {
    List<Patient> findAll();

}