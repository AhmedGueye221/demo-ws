package sn.courwebservice.demo_ws.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sn.courwebservice.demo_ws.models.Reservation;
import sn.courwebservice.demo_ws.repository.ReservationRepository;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/reservations")
public class ReservationController {

   
    private ReservationRepository reservationRepository;

    // GET /reservations/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        return reservationRepository.findById(id)
                .map(reservation -> ResponseEntity.ok(reservation))
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /reservations
    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        // Ici, tu peux appeler le service SOAP pour gérer la réservation
        // Pour l'instant, on sauvegarde directement en base (à modifier plus tard)
        Reservation savedReservation = reservationRepository.save(reservation);
        return ResponseEntity.ok(savedReservation);
    }
}
