
package com.example.LogiTrack.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.LogiTrack.Commande.Commande;

public interface CommandeRepo extends JpaRepository<Commande, Integer> {}