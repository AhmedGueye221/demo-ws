package sn.courwebservice.demo_ws.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.courwebservice.demo_ws.models.Reservation;
import sn.courwebservice.demo_ws.repository.ReservationRepository;


@RestController
//@RequestMapping(value = "/reservations", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping("/reservations")
@CrossOrigin(origins = "*")
public class ReservationController {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        return reservationRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

  
@PostMapping(consumes = "application/json", produces = "application/json")
public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation){
    try {
        Reservation savedReservation = reservationRepository.save(reservation);
        return ResponseEntity.ok(savedReservation);
    } catch (Exception e) {
        return ResponseEntity.badRequest().build();
    }
}

   @PostMapping(value = "/test", consumes = "application/json")
    public ResponseEntity<String> testJson(@RequestBody Map<String, Object> payload) {
        return ResponseEntity.ok("Payload reçu : " + payload.toString());
    }

}