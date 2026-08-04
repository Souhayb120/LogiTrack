package com.example.LogiTrack.Controllers;
import com.example.LogiTrack.services.ClientService;
import com.example.LogiTrack.Models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    public void saveCommande(@RequestBody Client client){
        clientService.ajouterClient(client);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','AGENT')")
    public List<Client> displayClients(){
       return clientService.afficherClients();
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','AGENT')")
    @GetMapping("/{id}")
    public Client displayClients(@PathVariable  int id){
        return clientService.afficherUnClient(id);
    }


    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable  int id){
        clientService.deleteClient(id);
    }

}
