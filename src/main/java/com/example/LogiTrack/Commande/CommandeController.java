package com.example.LogiTrack.Commande;

import com.example.LogiTrack.Client.Client;
import com.example.LogiTrack.Produit.Produit;
import com.example.LogiTrack.Produit.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @PostMapping
    public void saveCommande(@RequestBody Commande commande){
        commandeService.ajouterCommande(commande);
    }


    @GetMapping
    public List<Commande> displayCommandes(){
        return commandeService.afficherCommandes();
    }

    @GetMapping("/{id}")
    public Commande displayCommande(@PathVariable int id){
        return commandeService.afficherCommande(id);
    }


    @PutMapping("/{id}/status")
    public Commande updateStats(@PathVariable int id , @RequestBody String status){
        return commandeService.updateCommandeStatus(id,status);
    }

    @DeleteMapping("/{id}")
    public void deleteCommande(@PathVariable int id){
        commandeService.deleteCommande(id);
    }

    @GetMapping("/client/{id}")
    public List<Commande> displayCommandesByClientId(@PathVariable int id){
        return commandeService.findCommandeByClientId(id);
    }

}
