package sn.courwebservice.demo_ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.courwebservice.demo_ws.models.Utilisateurs;

public interface UtilisateurRepository extends JpaRepository<Utilisateurs, Long> {
    
}
