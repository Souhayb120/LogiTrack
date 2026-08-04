package com.example.LogiTrack.Mapper;

import com.example.LogiTrack.DTO.CommandeRequestDTO;
import com.example.LogiTrack.DTO.LigneCommandeRequestDTO;
import com.example.LogiTrack.Models.Commande;
import com.example.LogiTrack.Models.LigneCommande;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LigneCommandeMapper {
    LigneCommande toDTO(LigneCommandeRequestDTO ligneCommande);
    LigneCommandeRequestDTO toEntity(LigneCommande ligneCommande);
}
