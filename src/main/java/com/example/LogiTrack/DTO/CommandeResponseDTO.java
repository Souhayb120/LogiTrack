package com.example.LogiTrack.DTO;

import com.example.LogiTrack.Models.Client;
import com.example.LogiTrack.Models.LigneCommande;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommandeResponseDTO {
    private LocalDate date;
    private String status;
    private Client client;
    private int nomberligneCommandes;
}
