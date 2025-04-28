package sn.courwebservice.demo_ws.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateDebut;

    private LocalDate dateFin;

    //@ManyToOne
    //@JsonBackReference("utilisateur-reservation")
    //private Utilisateurs utilisateur;

    //@ManyToOne
    //@JsonBackReference("livre-reservation")
    //private Livres livre;

    @ManyToOne
@JsonIgnoreProperties("reservations") // ignore la collection dans l'objet utilisateur pour éviter boucle
private Utilisateurs utilisateur;

@ManyToOne
@JsonIgnoreProperties("reservations") // idem pour livre
private Livres livre;


    // Getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Utilisateurs getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateurs utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Livres getLivre() {
        return livre;
    }

    public void setLivre(Livres livre) {
        this.livre = livre;
    }
}
