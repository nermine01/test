package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Contrat;

@Repository
public interface IContratRepository extends CrudRepository<Contrat, Integer> {

    Contrat findByMatricule(String matricule);

}
