package com.example.LogiTrack.Mapper;


import com.example.LogiTrack.DTO.ClientRequestDTO;
import com.example.LogiTrack.DTO.ClientResponseDTO;
import com.example.LogiTrack.DTO.ProduitRequestDTO;
import com.example.LogiTrack.Models.Client;
import com.example.LogiTrack.Models.Produit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProduitMapper {
    Produit toDTO(ProduitRequestDTO produit);
    ProduitRequestDTO toEntity(Produit produit);
}
