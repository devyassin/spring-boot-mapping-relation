package com.example.patientapp.Controller;

import com.example.patientapp.Entity.Patient;
import com.example.patientapp.Repositery.PatientRepositery;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PatientRestController {

    private PatientRepositery patientRepositery;
    @GetMapping("/patients")
    List<Patient> patientList(){
        return patientRepositery.findAll();
    }

}
