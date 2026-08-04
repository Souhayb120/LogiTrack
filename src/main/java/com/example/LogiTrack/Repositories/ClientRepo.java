package com.example.LogiTrack.Repositories;
import com.example.LogiTrack.Models.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Integer> {
    Page<Client> findAll(Pageable pageable);
}