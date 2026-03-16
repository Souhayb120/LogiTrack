package com.example.LogiTrack.Commande;

import com.example.LogiTrack.Client.Client;
import jakarta.persistence.*;
import lombok.ToString;

import java.time.LocalDate;


@Entity
@Table(name = "commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private String status;

    @ManyToOne
    @JoinColumn(name = "client_id" , nullable = false)
    @ToString.Exclude
    private Client client;

    public Commande() {
    }

    public Commande(int id, LocalDate date, String status, Client client) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.client = client;
    }

    public Commande(LocalDate date, String status, Client client) {
        this.date = date;
        this.status = status;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}


