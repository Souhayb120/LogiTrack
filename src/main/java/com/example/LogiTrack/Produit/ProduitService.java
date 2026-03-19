package com.example.LogiTrack.Produit;

import com.example.LogiTrack.Client.Client;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProduitService {
    private final ProduitRepo produitRepo;
    public ProduitService(ProduitRepo produitRepo){
        this.produitRepo = produitRepo;
    }

    public void ajouterProduit(Produit produit){
        produitRepo.save(produit);
    }

    public List<Produit> afficherProduits(){
        return  produitRepo.findAll();
    }

    public void deleteProduit(int id){
        var produit = produitRepo.findById(id).orElse(null);
        produitRepo.delete(produit);
    }

    public Produit afficherProduit(int id){
        return produitRepo.findById(id).orElse(null);
    }
}
