package com.example.LogiTrack.Controllers;

import com.example.LogiTrack.services.CommandeService;
import com.example.LogiTrack.Models.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @PostMapping
    public void saveCommande(@RequestBody Commande commande){
        commandeService.ajouterCommande(commande);
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','AGENT')")
    @GetMapping
    public List<Commande> displayCommandes(){
        return commandeService.afficherCommandes();
    }


    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @GetMapping("/{id}")
    public Commande displayCommande(@PathVariable int id){
        return commandeService.afficherCommande(id);
    }


    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','AGENT')")
    @PutMapping("/{id}/status")
    public Commande updateStats(@PathVariable int id , @RequestBody String status){
        return commandeService.updateCommandeStatus(id,status);
    }

    @PreAuthorize("hasRole('MANAGER')")
    @DeleteMapping("/{id}")
    public void deleteCommande(@PathVariable int id){
        commandeService.deleteCommande(id);
    }


    @PreAuthorize("hasRole('MANAGER')")
    @GetMapping("/client/{id}")
    public List<Commande> displayCommandesByClientId(@PathVariable int id){
        return commandeService.findCommandeByClientId(id);
    }

}
