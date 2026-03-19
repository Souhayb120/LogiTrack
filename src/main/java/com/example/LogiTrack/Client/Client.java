package com.example.LogiTrack.Client;

import com.example.LogiTrack.Commande.Commande;
import jakarta.persistence.*;
import lombok.ToString;

import java.util.List;


@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String email;
    private String tel;


    @OneToMany(mappedBy = "client")

    private List<Commande> commandesList;


    public Client() {
    }

    public Client(String nom, String email, String tel, List<Commande> commandesList) {
        this.nom = nom;
        this.email = email;
        this.tel = tel;
        this.commandesList = commandesList;
    }

    public Client(int id, String nom, String email, String tel, List<Commande> commandesList) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.tel = tel;
        this.commandesList = commandesList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<Commande> getCommandesList() {
        return commandesList;
    }

    public void setCommandesList(List<Commande> commandesList) {
        this.commandesList = commandesList;
    }
}
