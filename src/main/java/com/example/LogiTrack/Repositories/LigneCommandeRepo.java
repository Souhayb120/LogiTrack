
package com.example.LogiTrack.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.LogiTrack.Models.LigneCommande;

public interface LigneCommandeRepo extends JpaRepository<LigneCommande, Integer> {}