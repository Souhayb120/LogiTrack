package com.example.LogiTrack.DTO;

import com.example.LogiTrack.Models.Commande;
import com.example.LogiTrack.Models.Produit;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class LigneCommandeRequestDTO {
    private int quantite;
}
