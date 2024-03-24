package com.example.patientapp;

import com.example.patientapp.Entity.*;
import com.example.patientapp.Repositery.ConsultationRepositery;
import com.example.patientapp.Repositery.MedecinRepositery;
import com.example.patientapp.Repositery.PatientRepositery;
import com.example.patientapp.Repositery.RendezVousRepositery;
import com.example.patientapp.Service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class PatientAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientAppApplication.class, args);
		System.out.println("hello");
	}

	@Bean
	CommandLineRunner start(IHospitalService hospitalService,
							PatientRepositery patientRepositery,
							MedecinRepositery medecinRepositery){
		return args ->{
			Stream.of("mohammed","saad","oussama").forEach(name->{
				Patient patient=new Patient();
				patient.setNom(name);
				patient.setDateNaissance(new Date());
				patient.setMalade(true);
				hospitalService.ajouterPatient(patient);
			});
			Stream.of("yassine","karim","mehdi").forEach(name->{
				Medecin medecin=new Medecin();
				medecin.setNom(name);
				medecin.setEmail(name+"@gmail.com");
				medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
				hospitalService.ajouterMedcin(medecin);
			});

			Patient patient= patientRepositery.findByNom("oussama");
			Medecin medecin=medecinRepositery.findByNom("yassine");
			RendezVous rendezVous=new RendezVous();
			rendezVous.setPatient(patient);
			rendezVous.setMedecin(medecin);
			rendezVous.setDateRDV(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			hospitalService.ajouterRendezvous(rendezVous);

			Consultation consultation=new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRapportConsulation(new Date());
			consultation.setRendezVous(rendezVous);
			hospitalService.ajouterConsultation(consultation);
		};
	}
}
