package com.example.LogiTrack.Mapper;


import com.example.LogiTrack.DTO.ClientRequestDTO;
import com.example.LogiTrack.DTO.ClientResponseDTO;
import com.example.LogiTrack.DTO.CommandeRequestDTO;
import com.example.LogiTrack.Models.Client;
import com.example.LogiTrack.Models.Commande;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommandeMapper {
    Commande toDTO(CommandeRequestDTO commande);
    CommandeRequestDTO toEntity(Commande commande);
}
