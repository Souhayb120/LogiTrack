package com.example.LogiTrack.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String categorie;
    private double prix;
    private int quantiteStock;

    @OneToMany(mappedBy = "produit")
    private List<LigneCommande> ligneCommandes = new ArrayList<>();

}
