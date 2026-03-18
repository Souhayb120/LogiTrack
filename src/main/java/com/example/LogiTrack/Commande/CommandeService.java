package com.example.LogiTrack.Commande;

import com.example.LogiTrack.Produit.Produit;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommandeService {
    private final CommandeRepo commandeRepo;
    public CommandeService(CommandeRepo commandeRepo){
        this.commandeRepo = commandeRepo;
    }

public List<Commande> afficherCommandes(){
        return commandeRepo.findAll();
}


public void ajouterCommande(Commande commande){
        commandeRepo.save(commande);
}

    public Commande afficherUnClient(int id){
        return commandeRepo.findById(id).orElse(null);
    }

    public Commande updateCommandeStatus(int id, Commande newData){
       Commande commande = commandeRepo.findById(id).orElse(null);
        if(commande != null){
            commande.setStatus(newData.getStatus());
            return commandeRepo.save(commande);
        }
        return null;
    }

    public void deleteCommande(Commande commande){
        commandeRepo.delete(commande);
    }

}
