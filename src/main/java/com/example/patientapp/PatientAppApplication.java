package com.example.patientapp;

import com.example.patientapp.Entity.*;
import com.example.patientapp.Repositery.ConsultationRepositery;
import com.example.patientapp.Repositery.MedecinRepositery;
import com.example.patientapp.Repositery.PatientRepositery;
import com.example.patientapp.Repositery.RendezVousRepositery;
import com.example.patientapp.Service.IHospitalService;
import com.example.patientapp.Service.UserServiceImpl;
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
							MedecinRepositery medecinRepositery,
							UserServiceImpl userService){
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


			User user1=new User();
			user1.setUsername("yassine lamouadden");
			user1.setPassword("123456");
			userService.addNewUser(user1);

			User user2=new User();
			user2.setUsername("karim");
			user2.setPassword("123456");
			userService.addNewUser(user2);

			Stream.of("STUDENT","USER","ADMIN").forEach(name->{
				Role role=new Role();
				role.setRoleName(name);
				userService.addNewRole(role);
			});

			userService.addRoleToUser("yassine lamouadden","ADMIN");
			userService.addRoleToUser("yassine lamouadden","USER");
			userService.addRoleToUser("karim","STUDENT");

			try {
				User user=userService.authenticate("yassine lamouadden",
						"123456");
				System.out.println(user);
				user.getRoles().forEach(role->{
					System.out.println("R:"+role);
				});
			}catch (Exception exception){
				System.out.println(exception);
			}
		};
	}
}
