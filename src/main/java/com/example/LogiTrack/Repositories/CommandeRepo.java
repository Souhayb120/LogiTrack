
package com.example.LogiTrack.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.LogiTrack.Models.Commande;

public interface CommandeRepo extends JpaRepository<Commande, Integer> {}