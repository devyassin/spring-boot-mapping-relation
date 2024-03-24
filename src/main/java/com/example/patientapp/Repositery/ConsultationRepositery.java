package com.example.patientapp.Repositery;

import com.example.patientapp.Entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepositery extends JpaRepository<Consultation,Long> {
}
