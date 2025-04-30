package sn.courwebservice.demo_ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.courwebservice.demo_ws.models.Livres;
import sn.courwebservice.demo_ws.models.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    /**
     * Trouve la dernière réservation pour un utilisateur et un livre donnés
     */
    Reservation findTopByUtilisateurIdAndLivreIdOrderByIdDesc(Long utilisateurId, Long livreId);

    /**
     * Vérifie si un livre a une réservation avec un statut donné
     */
    boolean existsByLivreAndStatut(Livres livre, String statut);
}