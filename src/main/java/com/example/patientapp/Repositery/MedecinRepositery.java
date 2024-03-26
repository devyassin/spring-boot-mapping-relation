package com.example.patientapp.Repositery;

import com.example.patientapp.Entity.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedecinRepositery extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String nom);
}
