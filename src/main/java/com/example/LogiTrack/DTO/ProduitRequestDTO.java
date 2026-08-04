package com.example.LogiTrack.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProduitRequestDTO {
    private String nom;
    private String categorie;
    private double prix;
    private int quantiteStock;
}
