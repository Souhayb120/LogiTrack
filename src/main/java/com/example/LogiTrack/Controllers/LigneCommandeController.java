package com.example.LogiTrack.Controllers;


import com.example.LogiTrack.Models.LigneCommande;
import com.example.LogiTrack.services.LigneCommandeService;
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
