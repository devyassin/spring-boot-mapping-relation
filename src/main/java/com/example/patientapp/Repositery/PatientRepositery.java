package com.example.patientapp.Repositery;

import com.example.patientapp.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepositery extends JpaRepository<Patient,Long> {
    Patient findByNom(String nom);
}
