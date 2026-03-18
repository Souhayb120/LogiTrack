package com.example.LogiTrack.Commande;

import com.example.LogiTrack.Client.Client;
import com.example.LogiTrack.ligneCommande.LigneCommande;
import jakarta.persistence.*;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private String status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @ToString.Exclude
    private Client client;

    @OneToMany(mappedBy = "commande")
    private List<LigneCommande> ligneCommandes;

    public Commande() {
    }

    public Commande(int id, LocalDate date, String status, Client client) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.client = client;
    }

    public Commande(LocalDate date, String status, Client client, List<LigneCommande> ligneCommandes) {
        this.date = date;
        this.status = status;
        this.client = client;
        this.ligneCommandes = ligneCommandes;
    }

    public List<LigneCommande> getligneCommandes() {
        return ligneCommandes;
    }

    public void setligneCommandes(List<LigneCommande> commandeList) {
        this.ligneCommandes = commandeList;
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


