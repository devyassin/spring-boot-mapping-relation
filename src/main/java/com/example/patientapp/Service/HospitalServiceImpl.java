package com.example.patientapp.Service;

import com.example.patientapp.Entity.Consultation;
import com.example.patientapp.Entity.Medecin;
import com.example.patientapp.Entity.Patient;
import com.example.patientapp.Entity.RendezVous;
import com.example.patientapp.Repositery.ConsultationRepositery;
import com.example.patientapp.Repositery.MedecinRepositery;
import com.example.patientapp.Repositery.PatientRepositery;
import com.example.patientapp.Repositery.RendezVousRepositery;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class HospitalServiceImpl implements IHospitalService {
    PatientRepositery patientRepositery;
    MedecinRepositery medecinRepositery;
    RendezVousRepositery rendezVousRepositery;
    ConsultationRepositery consultationRepositery;

    @Override
    public Patient ajouterPatient(Patient patient) {
        return patientRepositery.save(patient);
    }

    @Override
    public Medecin ajouterMedcin(Medecin medecin) {
        return medecinRepositery.save(medecin);
    }

    @Override
    public RendezVous ajouterRendezvous(RendezVous rendezVous) {
        return rendezVousRepositery.save(rendezVous);
    }

    @Override
    public Consultation ajouterConsultation(Consultation consultation) {
        return consultationRepositery.save(consultation);
    }
}
