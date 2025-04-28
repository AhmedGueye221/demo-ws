package sn.courwebservice.demo_ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.courwebservice.demo_ws.models.Livres;

public interface LivreRepository extends JpaRepository<Livres, Long> {
    // Méthode pour trouver les livres disponibles
    List<Livres> findByDisponibleTrue(); 

}
