package com.example.LogiTrack.services;

import com.example.LogiTrack.Models.Client;
import com.example.LogiTrack.Repositories.ClientRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepo clientRepo;

    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public void ajouterClient(Client client){
        clientRepo.save(client);
    }

    public List<Client> afficherClients(){
        return  clientRepo.findAll();
    }

    public void deleteClient(int id){
        clientRepo.deleteById(id);
    }

    public Client afficherUnClient(int id){
        return clientRepo.findById(id).orElse(null);
    }
}
