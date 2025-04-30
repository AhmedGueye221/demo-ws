package sn.courwebservice.demo_ws.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "livre_id")
    private Livres livre;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateurs utilisateur;

    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String statut;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Livres getLivre() { return livre; }
    public void setLivre(Livres livre) { this.livre = livre; }

    public Utilisateurs getUtilisateur() { return utilisateur; }
    public void setUtilisateur(Utilisateurs utilisateur) { this.utilisateur = utilisateur; }

    public LocalDate getDateDebut() { return dateDebut; }
    public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }

    public LocalDate getDateFin() { return dateFin; }
    public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
}