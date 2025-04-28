package sn.courwebservice.demo_ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.courwebservice.demo_ws.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findTopByUtilisateurIdAndLivreIdOrderByIdDesc(Long utilisateurId, Long livreId);
}
