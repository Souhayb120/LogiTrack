package com.example.LogiTrack.ligneCommande;


import com.example.LogiTrack.Commande.Commande;
import com.example.LogiTrack.Produit.Produit;
import com.example.LogiTrack.Produit.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ligneCommandes")
public class LigneCommandeController {
    @Autowired
    private LigneCommandeService ligneCommandeService;

    @PostMapping
    public void saveLigneCommande(@RequestBody LigneCommande ligneCommande){
        ligneCommandeService.ajouterProduitToCommande(ligneCommande);
    }

}
