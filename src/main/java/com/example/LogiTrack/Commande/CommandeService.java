package com.example.LogiTrack.Commande;

import com.example.LogiTrack.Client.Client;
import com.example.LogiTrack.Produit.Produit;
import com.example.LogiTrack.Produit.ProduitRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CommandeService {

    private final CommandeRepo commandeRepo;
    private final ProduitRepo produitRepo;
    public CommandeService(CommandeRepo commandeRepo , ProduitRepo produitRepo){
        this.commandeRepo = commandeRepo;
        this.produitRepo = produitRepo;
    }

public List<Commande> afficherCommandes(){
        return commandeRepo.findAll();
}

      public void ajouterCommande(Commande commande ){
        commandeRepo.save(commande);
}

    public Commande afficherCommande(int id){
        return commandeRepo.findById(id).orElse(null);
    }

    public Commande updateCommandeStatus(int id,String status){
            Commande commande = commandeRepo.findById(id).orElseThrow(() -> new RuntimeException("commande not found"));
            commande.setStatus(status);
            return commandeRepo.save(commande);
    }

    public void deleteCommande(int id){
        commandeRepo.deleteById(id);
    }

    public List<Commande> findCommandeByClientId(int clientId){
        List<Commande> commandeList = commandeRepo.findAll();
        return commandeList.stream().filter(c -> c.getClient().getId() == clientId).toList();
    }

}
