package com.example.LogiTrack.DTO;

import com.example.LogiTrack.Models.Commande;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponseDTO {
    private String nom;
    private String email;
    private String tel;
    private int nomberCommandes;

}
