package com.example.patientapp.Repositery;

import com.example.patientapp.Entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepositery extends JpaRepository<Consultation,Long> {
}
