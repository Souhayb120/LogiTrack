package com.example.LogiTrack.Controllers;


import com.example.LogiTrack.Models.Produit;
import com.example.LogiTrack.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @PostMapping
    public void saveProduit(@RequestBody Produit produit){
        produitService.ajouterProduit(produit);
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','AGENT')")
    @GetMapping
    public List<Produit> displayProduits(){
        return produitService.afficherProduits();
    }


    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @GetMapping("/findQuantite/{q}")
    public List<Produit> displayProduitsByQuantite(@PathVariable  int q){
        return produitService.findProduiByQuantite(q);
    }
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','AGENT')")
    @GetMapping("/{id}")
    public Produit displayProduit(@PathVariable  int id){
        return produitService.afficherProduit(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable  int id){
        produitService.deleteProduit(id);
    }

}
