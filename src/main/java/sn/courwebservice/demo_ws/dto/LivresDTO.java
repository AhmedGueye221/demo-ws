package sn.courwebservice.demo_ws.dto;

import java.util.ArrayList;
import java.util.List;

import sn.courwebservice.demo_ws.models.Reservation;

public class LivresDTO {
    private Long id;
    private String titre;
    private String auteur;
    private String isbn;
    private boolean disponible;
    
    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    
    private List<Reservation> reservation = new ArrayList<>(); // Liste des réservations associées au livre

    public List<Reservation> isReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

    // Constructeurs
    public LivresDTO() {
    }

    public LivresDTO(Long id, String titre, String auteur, String isbn) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
