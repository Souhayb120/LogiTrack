
package com.example.LogiTrack.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.LogiTrack.Models.Produit;

import java.util.List;

public interface ProduitRepo extends JpaRepository<Produit, Integer> {

    List<Produit> findByQuantiteStock(int quantite);

}