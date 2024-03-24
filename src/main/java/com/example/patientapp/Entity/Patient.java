package com.example.patientapp.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(length =50)
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private boolean malade;
    private int score;

    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY)
    private List<RendezVous> rendezVous;
}
