package sn.courwebservice.demo_ws.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.courwebservice.demo_ws.dto.ReservationRequest;
import sn.courwebservice.demo_ws.models.Reservation;
import sn.courwebservice.demo_ws.models.Livres;
import sn.courwebservice.demo_ws.models.Utilisateurs;
import sn.courwebservice.demo_ws.repository.ReservationRepository;
import sn.courwebservice.demo_ws.repository.LivreRepository;
import sn.courwebservice.demo_ws.repository.UtilisateurRepository;

@Service
public class ReservationService {
    
    private static final Logger logger = LoggerFactory.getLogger(ReservationService.class);

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private LivreRepository livreRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Transactional
    public Reservation createReservation(ReservationRequest request) {
        try {
            logger.debug("Début création réservation - userId: {}, livreId: {}", 
                request.getUserId(), request.getLivreId());

            // 1. Vérifier si le livre existe
            Livres livre = livreRepository.findById(request.getLivreId())
                .orElseThrow(() -> new RuntimeException("Livre non trouvé"));

            // 2. Vérifier si l'utilisateur existe
            Utilisateurs utilisateur = utilisateurRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

            // 3. Vérifier si le livre est déjà réservé
            boolean isReserved = reservationRepository.existsByLivreAndStatut(livre, "EN_ATTENTE");
            if (isReserved) {
                throw new RuntimeException("Le livre est déjà réservé");
            }

            // 4. Créer la réservation
            Reservation reservation = new Reservation();
            reservation.setLivre(livre);
            reservation.setUtilisateur(utilisateur);
            reservation.setDateDebut(request.getDateDebut());
            reservation.setDateFin(request.getDateFin());
            reservation.setStatut("EN_ATTENTE");

            return reservationRepository.save(reservation);
            
        } catch (Exception e) {
            logger.error("Erreur lors de la création de la réservation: {}", e.getMessage());
            throw new RuntimeException("Erreur lors de la création de la réservation: " + e.getMessage());
        }
    }

    public Reservation getReservation(Long id) {
        return reservationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Réservation non trouvée"));
    }
}