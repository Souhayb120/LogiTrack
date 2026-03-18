package com.example.LogiTrack.Client;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Client> displayClients(){
       return clientService.afficherClients();
    }

    @GetMapping("/{id}")
    public Client displayClients(@PathVariable  int id){
        return clientService.afficherUnClient(id);
    }


    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable  int id){
        clientService.deleteClient(id);
    }

}
