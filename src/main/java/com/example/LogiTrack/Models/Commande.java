package com.example.LogiTrack.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private String status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @ToString.Exclude
    @JsonIgnore
    private Client client;

    @OneToMany(mappedBy = "commande")
    private List<LigneCommande> ligneCommandes = new ArrayList<>();


}


