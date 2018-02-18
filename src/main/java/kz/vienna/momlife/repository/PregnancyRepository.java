package kz.vienna.momlife.repository;

import kz.vienna.momlife.model.entity.Pregnancy;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PregnancyRepository extends CrudRepository<Pregnancy, Long> {
    List<Pregnancy> findAll();

}