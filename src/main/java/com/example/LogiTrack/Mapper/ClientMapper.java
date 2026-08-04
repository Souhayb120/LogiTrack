package com.example.LogiTrack.Mapper;

import com.example.LogiTrack.DTO.ClientRequestDTO;
import com.example.LogiTrack.DTO.ClientResponseDTO;
import com.example.LogiTrack.Models.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper  {
    Client toDTO(ClientRequestDTO client);
    ClientResponseDTO toEntity(Client client);
}
