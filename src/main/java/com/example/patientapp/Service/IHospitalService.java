package com.example.patientapp.Service;

import com.example.patientapp.Entity.Consultation;
import com.example.patientapp.Entity.Medecin;
import com.example.patientapp.Entity.Patient;
import com.example.patientapp.Entity.RendezVous;

public interface IHospitalService {
    Patient ajouterPatient(Patient patient);
    Medecin ajouterMedcin(Medecin medecin);
    RendezVous ajouterRendezvous(RendezVous rendezVous);
    Consultation ajouterConsultation(Consultation consultation);
}
