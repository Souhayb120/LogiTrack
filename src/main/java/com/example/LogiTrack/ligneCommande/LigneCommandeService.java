package com.example.LogiTrack.ligneCommande;

import com.example.LogiTrack.Commande.Commande;
import com.example.LogiTrack.Commande.CommandeRepo;
import com.example.LogiTrack.Produit.Produit;
import com.example.LogiTrack.Produit.ProduitRepo;
import com.example.LogiTrack.exceptions.DataNotFound;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.zip.DataFormatException;

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
