package sn.courwebservice.demo_ws.dto;

public class UtilisateursDTO {
    private Long id;
    private String nom;
    private String email;

    // Constructeurs
    public UtilisateursDTO() {
    }

    public UtilisateursDTO(Long id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
