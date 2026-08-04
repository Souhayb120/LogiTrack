package com.example.LogiTrack.DTO;

import com.example.LogiTrack.Models.LigneCommande;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProduitResposeDTO {
    private String nom;
    private String categorie;
    private double prix;
    private int quantiteStock;
    private int nomberligneCommandes ;

}
