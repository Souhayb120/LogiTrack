package com.example.LogiTrack.services;

import com.example.LogiTrack.Models.LigneCommande;
import com.example.LogiTrack.Repositories.CommandeRepo;
import com.example.LogiTrack.Repositories.LigneCommandeRepo;
import com.example.LogiTrack.Repositories.ProduitRepo;
import com.example.LogiTrack.exceptions.DataNotFound;
import org.springframework.stereotype.Service;

@Service
public class LigneCommandeService {


    private final LigneCommandeRepo ligneCommandeRepo;
    private final CommandeRepo commandeRepo;
    private final ProduitRepo produitRepo;

    public LigneCommandeService(LigneCommandeRepo ligneCommandeRepo, CommandeRepo commandeRepo, ProduitRepo produitRepo){
        this.ligneCommandeRepo = ligneCommandeRepo;
        this.commandeRepo = commandeRepo;
        this.produitRepo = produitRepo;
    }

    public LigneCommande ajouterProduitToCommande(LigneCommande lc){
        LigneCommande ligneCommande  = new LigneCommande();
        var cmd = commandeRepo.findById(lc.getCommande().getId()).orElseThrow(DataNotFound::new);
        var prod = produitRepo.findById(lc.getProduit().getId()).orElseThrow(DataNotFound::new);
        ligneCommande.setCommande(cmd);
        ligneCommande.setProduit(prod);
        ligneCommande.setQuantite(lc.getQuantite());
        return ligneCommandeRepo.save(ligneCommande);
    }



}
