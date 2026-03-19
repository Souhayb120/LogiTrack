package com.example.LogiTrack.Produit;


import com.example.LogiTrack.Client.Client;
import com.example.LogiTrack.Client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @PostMapping
    public void saveProduit(@RequestBody Produit produit){
        produitService.ajouterProduit(produit);
    }


    @GetMapping
    public List<Produit> displayProduits(){
        return produitService.afficherProduits();
    }

    @GetMapping("/{id}")
    public Produit displayProduit(@PathVariable  int id){
        return produitService.afficherProduit(id);
    }


    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable  int id){
        produitService.deleteProduit(id);
    }

}
