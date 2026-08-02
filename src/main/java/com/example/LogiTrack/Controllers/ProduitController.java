package com.example.LogiTrack.Controllers;


import com.example.LogiTrack.Models.Produit;
import com.example.LogiTrack.services.ProduitService;
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


    @GetMapping("/findQuantite/{q}")
    public List<Produit> displayProduitsByQuantite(@PathVariable  int q){
        return produitService.findProduiByQuantite(q);
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
